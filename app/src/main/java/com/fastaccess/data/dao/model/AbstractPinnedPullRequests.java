package com.fastaccess.data.dao.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fastaccess.App;
import com.fastaccess.data.dao.converters.PullRequestConverter;
import com.fastaccess.helper.RxHelper;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.requery.Convert;
import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;

/**
 * Created by Hashemsergani on 14.10.17.
 */

@Entity public class AbstractPinnedPullRequests {

    @Key @Generated long id;
    @io.requery.Nullable int entryCount;
    @io.requery.Nullable String login;
    @io.requery.Nullable @Convert(PullRequestConverter.class) PullRequest pullRequest;
    @io.requery.Nullable long pullRequestId;

    public AbstractPinnedPullRequests() {
    }

    public static void pinUpin(@NonNull PullRequest pullRequest) {
        PinnedPullRequests pinnedPullRequests = get(pullRequest.getId());
        if (pinnedPullRequests == null) {
            PinnedPullRequests pinned = new PinnedPullRequests();
            pinned.setLogin(Login.getUser().getLogin());
            pinned.setPullRequest(pullRequest);
            pinned.setPullRequestId(pullRequest.getId());
            try {
                App.getInstance().getDataStore().toBlocking().insert(pinned);
            } catch (Exception ignored) {}
        } else {
            delete(pullRequest.getId());
        }
    }

    @Nullable public static PinnedPullRequests get(long pullRequestId) {
        return App.getInstance().getDataStore().select(PinnedPullRequests.class)
                .where(PinnedPullRequests.PULL_REQUEST_ID.eq(pullRequestId))
                .get()
                .firstOrNull();
    }

    public static void delete(long pullRequestId) {
        App.getInstance().getDataStore().delete(PinnedPullRequests.class)
                .where(PinnedPullRequests.PULL_REQUEST_ID.eq(pullRequestId))
                .get()
                .value();
    }

    @NonNull public static Disposable updateEntry(@NonNull long pullRequestId) {
        return RxHelper.getObservable(Observable.fromPublisher(e -> {
            PinnedPullRequests pinned = get(pullRequestId);
            if (pinned != null) {
                pinned.setEntryCount(pinned.getEntryCount() + 1);
                App.getInstance().getDataStore().toBlocking().update(pinned);
                e.onNext("");
            }
            e.onComplete();
        })).subscribe(o -> {/*do nothing*/}, Throwable::printStackTrace);
    }

    @NonNull public static Single<List<PullRequest>> getMyPinnedPullRequests() {
        return App.getInstance().getDataStore().select(PinnedPullRequests.class)
                .where(PinnedPullRequests.LOGIN.eq(Login.getUser().getLogin()).or(PinnedPullRequests.LOGIN.isNull()))
                .orderBy(PinnedPullRequests.ENTRY_COUNT.desc(), PinnedPullRequests.ID.desc())
                .get()
                .observable()
                .map(PinnedPullRequests::getPullRequest)
                .toList();
    }

    public static boolean isPinned(long pullRequestId) {
        return get(pullRequestId) != null;
    }

}
