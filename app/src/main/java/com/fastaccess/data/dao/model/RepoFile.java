// Generated file do not edit, generated by io.requery.processor.EntityProcessor
package com.fastaccess.data.dao.model;

import android.os.Parcel;
import com.fastaccess.data.dao.types.FilesType;
import io.requery.Persistable;
import io.requery.meta.AttributeBuilder;
import io.requery.meta.NumericAttribute;
import io.requery.meta.QueryAttribute;
import io.requery.meta.StringAttribute;
import io.requery.meta.Type;
import io.requery.meta.TypeBuilder;
import io.requery.proxy.EntityProxy;
import io.requery.proxy.LongProperty;
import io.requery.proxy.Property;
import io.requery.proxy.PropertyState;
import io.requery.util.function.Function;
import io.requery.util.function.Supplier;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import javax.annotation.Generated;

@Generated("io.requery.processor.EntityProcessor")
public class RepoFile extends AbstractRepoFile implements Persistable {
    public static final NumericAttribute<RepoFile, Long> ID = 
    new AttributeBuilder<RepoFile, Long>("id", long.class)
    .setProperty(new LongProperty<RepoFile>() {
        @Override
        public Long get(RepoFile entity) {
            return entity.id;
        }

        @Override
        public void set(RepoFile entity, Long value) {
            entity.id = value;
        }

        @Override
        public long getLong(RepoFile entity) {
            return entity.id;
        }

        @Override
        public void setLong(RepoFile entity, long value) {
            entity.id = value;
        }
    })
    .setPropertyName("id")
    .setPropertyState(new Property<RepoFile, PropertyState>() {
        @Override
        public PropertyState get(RepoFile entity) {
            return entity.$id_state;
        }

        @Override
        public void set(RepoFile entity, PropertyState value) {
            entity.$id_state = value;
        }
    })
    .setKey(true)
    .setGenerated(true)
    .setReadOnly(true)
    .setLazy(false)
    .setNullable(false)
    .setUnique(false)
    .buildNumeric();

    public static final StringAttribute<RepoFile, String> LOGIN = 
    new AttributeBuilder<RepoFile, String>("login", String.class)
    .setProperty(new Property<RepoFile, String>() {
        @Override
        public String get(RepoFile entity) {
            return entity.login;
        }

        @Override
        public void set(RepoFile entity, String value) {
            entity.login = value;
        }
    })
    .setPropertyName("login")
    .setPropertyState(new Property<RepoFile, PropertyState>() {
        @Override
        public PropertyState get(RepoFile entity) {
            return entity.$login_state;
        }

        @Override
        public void set(RepoFile entity, PropertyState value) {
            entity.$login_state = value;
        }
    })
    .setGenerated(false)
    .setReadOnly(false)
    .setLazy(false)
    .setNullable(true)
    .setUnique(false)
    .buildString();

    public static final NumericAttribute<RepoFile, Long> SIZE = 
    new AttributeBuilder<RepoFile, Long>("size", long.class)
    .setProperty(new LongProperty<RepoFile>() {
        @Override
        public Long get(RepoFile entity) {
            return entity.size;
        }

        @Override
        public void set(RepoFile entity, Long value) {
            entity.size = value;
        }

        @Override
        public long getLong(RepoFile entity) {
            return entity.size;
        }

        @Override
        public void setLong(RepoFile entity, long value) {
            entity.size = value;
        }
    })
    .setPropertyName("size")
    .setPropertyState(new Property<RepoFile, PropertyState>() {
        @Override
        public PropertyState get(RepoFile entity) {
            return entity.$size_state;
        }

        @Override
        public void set(RepoFile entity, PropertyState value) {
            entity.$size_state = value;
        }
    })
    .setGenerated(false)
    .setReadOnly(false)
    .setLazy(false)
    .setNullable(false)
    .setUnique(false)
    .buildNumeric();

    public static final StringAttribute<RepoFile, String> DOWNLOAD_URL = 
    new AttributeBuilder<RepoFile, String>("downloadUrl", String.class)
    .setProperty(new Property<RepoFile, String>() {
        @Override
        public String get(RepoFile entity) {
            return entity.downloadUrl;
        }

        @Override
        public void set(RepoFile entity, String value) {
            entity.downloadUrl = value;
        }
    })
    .setPropertyName("downloadUrl")
    .setPropertyState(new Property<RepoFile, PropertyState>() {
        @Override
        public PropertyState get(RepoFile entity) {
            return entity.$downloadUrl_state;
        }

        @Override
        public void set(RepoFile entity, PropertyState value) {
            entity.$downloadUrl_state = value;
        }
    })
    .setGenerated(false)
    .setReadOnly(false)
    .setLazy(false)
    .setNullable(true)
    .setUnique(false)
    .buildString();

    public static final StringAttribute<RepoFile, String> NAME = 
    new AttributeBuilder<RepoFile, String>("name", String.class)
    .setProperty(new Property<RepoFile, String>() {
        @Override
        public String get(RepoFile entity) {
            return entity.name;
        }

        @Override
        public void set(RepoFile entity, String value) {
            entity.name = value;
        }
    })
    .setPropertyName("name")
    .setPropertyState(new Property<RepoFile, PropertyState>() {
        @Override
        public PropertyState get(RepoFile entity) {
            return entity.$name_state;
        }

        @Override
        public void set(RepoFile entity, PropertyState value) {
            entity.$name_state = value;
        }
    })
    .setGenerated(false)
    .setReadOnly(false)
    .setLazy(false)
    .setNullable(true)
    .setUnique(false)
    .buildString();

    public static final StringAttribute<RepoFile, String> PATH = 
    new AttributeBuilder<RepoFile, String>("path", String.class)
    .setProperty(new Property<RepoFile, String>() {
        @Override
        public String get(RepoFile entity) {
            return entity.path;
        }

        @Override
        public void set(RepoFile entity, String value) {
            entity.path = value;
        }
    })
    .setPropertyName("path")
    .setPropertyState(new Property<RepoFile, PropertyState>() {
        @Override
        public PropertyState get(RepoFile entity) {
            return entity.$path_state;
        }

        @Override
        public void set(RepoFile entity, PropertyState value) {
            entity.$path_state = value;
        }
    })
    .setGenerated(false)
    .setReadOnly(false)
    .setLazy(false)
    .setNullable(true)
    .setUnique(false)
    .buildString();

    public static final QueryAttribute<RepoFile, FilesType> TYPE = 
    new AttributeBuilder<RepoFile, FilesType>("type", FilesType.class)
    .setProperty(new Property<RepoFile, FilesType>() {
        @Override
        public FilesType get(RepoFile entity) {
            return entity.type;
        }

        @Override
        public void set(RepoFile entity, FilesType value) {
            entity.type = value;
        }
    })
    .setPropertyName("type")
    .setPropertyState(new Property<RepoFile, PropertyState>() {
        @Override
        public PropertyState get(RepoFile entity) {
            return entity.$type_state;
        }

        @Override
        public void set(RepoFile entity, PropertyState value) {
            entity.$type_state = value;
        }
    })
    .setGenerated(false)
    .setReadOnly(false)
    .setLazy(false)
    .setNullable(true)
    .setUnique(false)
    .build();

    public static final StringAttribute<RepoFile, String> URL = 
    new AttributeBuilder<RepoFile, String>("url", String.class)
    .setProperty(new Property<RepoFile, String>() {
        @Override
        public String get(RepoFile entity) {
            return entity.url;
        }

        @Override
        public void set(RepoFile entity, String value) {
            entity.url = value;
        }
    })
    .setPropertyName("url")
    .setPropertyState(new Property<RepoFile, PropertyState>() {
        @Override
        public PropertyState get(RepoFile entity) {
            return entity.$url_state;
        }

        @Override
        public void set(RepoFile entity, PropertyState value) {
            entity.$url_state = value;
        }
    })
    .setGenerated(false)
    .setReadOnly(false)
    .setLazy(false)
    .setNullable(true)
    .setUnique(false)
    .buildString();

    public static final StringAttribute<RepoFile, String> REPO_ID = 
    new AttributeBuilder<RepoFile, String>("repoId", String.class)
    .setProperty(new Property<RepoFile, String>() {
        @Override
        public String get(RepoFile entity) {
            return entity.repoId;
        }

        @Override
        public void set(RepoFile entity, String value) {
            entity.repoId = value;
        }
    })
    .setPropertyName("repoId")
    .setPropertyState(new Property<RepoFile, PropertyState>() {
        @Override
        public PropertyState get(RepoFile entity) {
            return entity.$repoId_state;
        }

        @Override
        public void set(RepoFile entity, PropertyState value) {
            entity.$repoId_state = value;
        }
    })
    .setGenerated(false)
    .setReadOnly(false)
    .setLazy(false)
    .setNullable(true)
    .setUnique(false)
    .buildString();

    public static final StringAttribute<RepoFile, String> GIT_URL = 
    new AttributeBuilder<RepoFile, String>("gitUrl", String.class)
    .setProperty(new Property<RepoFile, String>() {
        @Override
        public String get(RepoFile entity) {
            return entity.gitUrl;
        }

        @Override
        public void set(RepoFile entity, String value) {
            entity.gitUrl = value;
        }
    })
    .setPropertyName("gitUrl")
    .setPropertyState(new Property<RepoFile, PropertyState>() {
        @Override
        public PropertyState get(RepoFile entity) {
            return entity.$gitUrl_state;
        }

        @Override
        public void set(RepoFile entity, PropertyState value) {
            entity.$gitUrl_state = value;
        }
    })
    .setGenerated(false)
    .setReadOnly(false)
    .setLazy(false)
    .setNullable(true)
    .setUnique(false)
    .buildString();

    public static final StringAttribute<RepoFile, String> HTML_URL = 
    new AttributeBuilder<RepoFile, String>("htmlUrl", String.class)
    .setProperty(new Property<RepoFile, String>() {
        @Override
        public String get(RepoFile entity) {
            return entity.htmlUrl;
        }

        @Override
        public void set(RepoFile entity, String value) {
            entity.htmlUrl = value;
        }
    })
    .setPropertyName("htmlUrl")
    .setPropertyState(new Property<RepoFile, PropertyState>() {
        @Override
        public PropertyState get(RepoFile entity) {
            return entity.$htmlUrl_state;
        }

        @Override
        public void set(RepoFile entity, PropertyState value) {
            entity.$htmlUrl_state = value;
        }
    })
    .setGenerated(false)
    .setReadOnly(false)
    .setLazy(false)
    .setNullable(true)
    .setUnique(false)
    .buildString();

    public static final StringAttribute<RepoFile, String> SHA = 
    new AttributeBuilder<RepoFile, String>("sha", String.class)
    .setProperty(new Property<RepoFile, String>() {
        @Override
        public String get(RepoFile entity) {
            return entity.sha;
        }

        @Override
        public void set(RepoFile entity, String value) {
            entity.sha = value;
        }
    })
    .setPropertyName("sha")
    .setPropertyState(new Property<RepoFile, PropertyState>() {
        @Override
        public PropertyState get(RepoFile entity) {
            return entity.$sha_state;
        }

        @Override
        public void set(RepoFile entity, PropertyState value) {
            entity.$sha_state = value;
        }
    })
    .setGenerated(false)
    .setReadOnly(false)
    .setLazy(false)
    .setNullable(true)
    .setUnique(false)
    .buildString();

    public static final Type<RepoFile> $TYPE = new TypeBuilder<RepoFile>(RepoFile.class, "RepoFile")
    .setBaseType(AbstractRepoFile.class)
    .setCacheable(true)
    .setImmutable(false)
    .setReadOnly(false)
    .setStateless(false)
    .setView(false)
    .setFactory(new Supplier<RepoFile>() {
        @Override
        public RepoFile get() {
            return new RepoFile();
        }
    })
    .setProxyProvider(new Function<RepoFile, EntityProxy<RepoFile>>() {
        @Override
        public EntityProxy<RepoFile> apply(RepoFile entity) {
            return entity.$proxy;
        }
    })
    .addAttribute(PATH)
    .addAttribute(REPO_ID)
    .addAttribute(DOWNLOAD_URL)
    .addAttribute(SIZE)
    .addAttribute(LOGIN)
    .addAttribute(GIT_URL)
    .addAttribute(ID)
    .addAttribute(HTML_URL)
    .addAttribute(TYPE)
    .addAttribute(SHA)
    .addAttribute(URL)
    .addAttribute(NAME)
    .build();

    private PropertyState $id_state;

    private PropertyState $login_state;

    private PropertyState $size_state;

    private PropertyState $downloadUrl_state;

    private PropertyState $name_state;

    private PropertyState $path_state;

    private PropertyState $type_state;

    private PropertyState $url_state;

    private PropertyState $repoId_state;

    private PropertyState $gitUrl_state;

    private PropertyState $htmlUrl_state;

    private PropertyState $sha_state;

    private final transient EntityProxy<RepoFile> $proxy = new EntityProxy<RepoFile>(this, $TYPE);

    protected RepoFile(Parcel in) {
        super(in);
    }

    public RepoFile() {
    }

    public long getId() {
        return $proxy.get(ID);
    }

    public String getLogin() {
        return $proxy.get(LOGIN);
    }

    public void setLogin(String login) {
        $proxy.set(LOGIN, login);
    }

    public long getSize() {
        return $proxy.get(SIZE);
    }

    public void setSize(long size) {
        $proxy.set(SIZE, size);
    }

    public String getDownloadUrl() {
        return $proxy.get(DOWNLOAD_URL);
    }

    public void setDownloadUrl(String downloadUrl) {
        $proxy.set(DOWNLOAD_URL, downloadUrl);
    }

    public String getName() {
        return $proxy.get(NAME);
    }

    public void setName(String name) {
        $proxy.set(NAME, name);
    }

    public String getPath() {
        return $proxy.get(PATH);
    }

    public void setPath(String path) {
        $proxy.set(PATH, path);
    }

    public FilesType getType() {
        return $proxy.get(TYPE);
    }

    public void setType(FilesType type) {
        $proxy.set(TYPE, type);
    }

    public String getUrl() {
        return $proxy.get(URL);
    }

    public void setUrl(String url) {
        $proxy.set(URL, url);
    }

    public String getRepoId() {
        return $proxy.get(REPO_ID);
    }

    public void setRepoId(String repoId) {
        $proxy.set(REPO_ID, repoId);
    }

    public String getGitUrl() {
        return $proxy.get(GIT_URL);
    }

    public void setGitUrl(String gitUrl) {
        $proxy.set(GIT_URL, gitUrl);
    }

    public String getHtmlUrl() {
        return $proxy.get(HTML_URL);
    }

    public void setHtmlUrl(String htmlUrl) {
        $proxy.set(HTML_URL, htmlUrl);
    }

    public String getSha() {
        return $proxy.get(SHA);
    }

    public void setSha(String sha) {
        $proxy.set(SHA, sha);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof RepoFile && ((RepoFile)obj).$proxy.equals(this.$proxy);
    }

    @Override
    public int hashCode() {
        return $proxy.hashCode();
    }

    @Override
    public String toString() {
        return $proxy.toString();
    }
}