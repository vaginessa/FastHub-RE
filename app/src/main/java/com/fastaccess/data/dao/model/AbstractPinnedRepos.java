package com.fastaccess.data.dao.model;

import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fastaccess.App;
import com.fastaccess.data.dao.converters.RepoConverter;
import com.fastaccess.helper.RxHelper;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.requery.Column;
import io.requery.Convert;
import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;

/**
 * Created by Kosh on 25 Mar 2017, 7:29 PM
 */

@Entity public abstract class AbstractPinnedRepos implements Parcelable {
    @Key @Generated long id;
    @Column(unique = false) String repoFullName;
    @Convert(RepoConverter.class) Repo pinnedRepo;
    @io.requery.Nullable int entryCount;
    @io.requery.Nullable String login;

    public AbstractPinnedRepos() {
    }

    public static Single<PinnedRepos> update(@NonNull PinnedRepos entity) {
        return RxHelper.getSingle(App.getInstance().getDataStore().update(entity));
    }

    public static boolean pinUpin(@NonNull Repo repo) {
        PinnedRepos pinnedRepos = get(repo.getFullName());
        if (pinnedRepos == null) {
            PinnedRepos pinned = new PinnedRepos();
            pinned.setRepoFullName(repo.getFullName());
            pinned.setLogin(Login.getUser().getLogin());
            pinned.setPinnedRepo(repo);
            try {
                App.getInstance().getDataStore().toBlocking().insert(pinned);
                return true;
            } catch (Exception ignored) {}
        } else {
            delete(pinnedRepos.getId());
        }
        return false;
    }

    @Nullable public static PinnedRepos get(long id) {
        return App.getInstance().getDataStore().select(PinnedRepos.class)
                .where(PinnedRepos.ID.eq(id))
                .get()
                .firstOrNull();
    }

    @Nullable public static PinnedRepos get(@NonNull String repoFullName) {
        return App.getInstance().getDataStore().toBlocking().select(PinnedRepos.class)
                .where(PinnedRepos.REPO_FULL_NAME.eq(repoFullName).and(PinnedRepos.LOGIN.eq(Login.getUser().getLogin()))
                        .or(PinnedRepos.REPO_FULL_NAME.eq(repoFullName)))
                .get()
                .firstOrNull();
    }

    public static boolean isPinned(@NonNull String repoFullName) {
        return get(repoFullName) != null;
    }

    @NonNull public static Disposable updateEntry(@NonNull String repoFullName) {
        return RxHelper.getObservable(Observable.fromPublisher(e -> {
            PinnedRepos pinned = get(repoFullName);
            if (pinned != null) {
                pinned.setEntryCount(pinned.getEntryCount() + 1);
                App.getInstance().getDataStore().toBlocking().update(pinned);
                e.onNext("");
            }
            e.onComplete();
        })).subscribe(o -> {/*do nothing*/}, Throwable::printStackTrace);
    }

    @NonNull public static Single<List<PinnedRepos>> getMyPinnedRepos() {
        return App.getInstance().getDataStore().select(PinnedRepos.class)
                .where(PinnedRepos.LOGIN.eq(Login.getUser().getLogin())
                        .or(PinnedRepos.LOGIN.isNull()))
                .orderBy(PinnedRepos.ENTRY_COUNT.desc(), PinnedRepos.ID.desc())
                .get()
                .observable()
                .toList();

    }

    @NonNull public static Observable<List<PinnedRepos>> getMenuRepos() {
        return App.getInstance().getDataStore().select(PinnedRepos.class)
                .where(PinnedRepos.LOGIN.eq(Login.getUser().getLogin()))
                .orderBy(PinnedRepos.ENTRY_COUNT.desc(), PinnedRepos.ID.desc())
                .limit(5)
                .get()
                .observable()
                .toList()
                .toObservable();
    }

//    public static Disposable migrateToVersion4() {
//        return RxHelper.getObservable(Observable.fromPublisher(e -> {
//            try {
//                Login login = Login.getUser();
//                if (login == null) {
//                    e.onComplete();
//                    return;
//                }
//                BlockingEntityStore<Persistable> reactiveEntityStore = App.getInstance().getDataStore().toBlocking();
//                List<PinnedRepos> pinnedRepos = reactiveEntityStore.select(PinnedRepos.class)
//                        .where(LOGIN.isNull())
//                        .get()
//                        .toList();
//                if (pinnedRepos != null) {
//                    for (PinnedRepos pinnedRepo : pinnedRepos) {
//                        pinnedRepo.setRepoFullName(login.getLogin());
//                        reactiveEntityStore.update(pinnedRepo);
//                    }
//                }
//                Logger.e("Hello");
//            } catch (Exception ignored) {
//                e.onError(ignored);
//            }
//            e.onComplete();
//        })).subscribe(o -> {/*do nothing*/}, Throwable::printStackTrace);
//    }

    public static void delete(long id) {
        App.getInstance().getDataStore().delete(PinnedRepos.class)
                .where(PinnedRepos.ID.eq(id))
                .get()
                .value();
    }
}
