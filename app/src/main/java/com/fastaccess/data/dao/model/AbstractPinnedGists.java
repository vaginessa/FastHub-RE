package com.fastaccess.data.dao.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fastaccess.App;
import com.fastaccess.data.dao.converters.GistConverter;

import java.util.List;

import io.reactivex.Single;
import io.requery.Convert;
import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;

/**
 * Created by Hashemsergani on 14.10.17.
 */

@Entity public class AbstractPinnedGists {

    @Key @Generated long id;
    @io.requery.Nullable int entryCount;
    @io.requery.Nullable String login;
    @io.requery.Nullable @Convert(GistConverter.class) Gist gist;
    @io.requery.Nullable long gistId;

    public AbstractPinnedGists() {
    }

    public static void pinUpin(@NonNull Gist gist) {
        PinnedGists pinnedIssues = get(gist.getGistId().hashCode());
        if (pinnedIssues == null) {
            PinnedGists pinned = new PinnedGists();
            pinned.setLogin(Login.getUser().getLogin());
            pinned.setGist(gist);
            pinned.setGistId(gist.getGistId().hashCode());
            try {
                App.getInstance().getDataStore().toBlocking().insert(pinned);
            } catch (Exception ignored) {}
        } else {
            delete(gist.getGistId().hashCode());
        }
    }

    @Nullable public static PinnedGists get(long gistId) {
        return App.getInstance().getDataStore().select(PinnedGists.class)
                .where(PinnedGists.GIST_ID.eq(gistId))
                .get()
                .firstOrNull();
    }

    public static void delete(long gistId) {
        App.getInstance().getDataStore().delete(PinnedGists.class)
                .where(PinnedGists.GIST_ID.eq(gistId))
                .get()
                .value();
    }

    @NonNull public static Single<List<Gist>> getMyPinnedGists() {
        return App.getInstance().getDataStore().select(PinnedGists.class)
                .where(PinnedGists.LOGIN.eq(Login.getUser().getLogin()).or(PinnedGists.LOGIN.isNull()))
                .orderBy(PinnedGists.ENTRY_COUNT.desc(), PinnedGists.ID.desc())
                .get()
                .observable()
                .map(PinnedGists::getGist)
                .toList();
    }

    public static boolean isPinned(long gistId) {
        return get(gistId) != null;
    }
}
