// Generated file do not edit, generated by io.requery.processor.EntityProcessor
package com.fastaccess.data.dao.model;

import android.os.Parcel;
import io.requery.Persistable;
import io.requery.meta.AttributeBuilder;
import io.requery.meta.NumericAttribute;
import io.requery.meta.QueryAttribute;
import io.requery.meta.StringAttribute;
import io.requery.meta.Type;
import io.requery.meta.TypeBuilder;
import io.requery.proxy.EntityProxy;
import io.requery.proxy.IntProperty;
import io.requery.proxy.LongProperty;
import io.requery.proxy.Property;
import io.requery.proxy.PropertyState;
import io.requery.util.function.Function;
import io.requery.util.function.Supplier;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Date;
import javax.annotation.Generated;

@Generated("io.requery.processor.EntityProcessor")
public class GitHubPackage extends AbstractGitHubPackage implements Persistable {
    public static final NumericAttribute<GitHubPackage, Long> ID =
            new AttributeBuilder<GitHubPackage, Long>("id", long.class)
                    .setProperty(new LongProperty<GitHubPackage>() {
                        @Override
                        public Long get(GitHubPackage entity) {
                            return entity.id;
                        }

                        @Override
                        public void set(GitHubPackage entity, Long value) {
                            entity.id = value;
                        }

                        @Override
                        public long getLong(GitHubPackage entity) {
                            return entity.id;
                        }

                        @Override
                        public void setLong(GitHubPackage entity, long value) {
                            entity.id = value;
                        }
                    })
                    .setPropertyName("id")
                    .setPropertyState(new Property<GitHubPackage, PropertyState>() {
                        @Override
                        public PropertyState get(GitHubPackage entity) {
                            return entity.$id_state;
                        }

                        @Override
                        public void set(GitHubPackage entity, PropertyState value) {
                            entity.$id_state = value;
                        }
                    })
                    .setKey(true)
                    .setGenerated(false)
                    .setReadOnly(false)
                    .setLazy(false)
                    .setNullable(false)
                    .setUnique(false)
                    .buildNumeric();

    public static final QueryAttribute<GitHubPackage, User> OWNER =
            new AttributeBuilder<GitHubPackage, User>("owner", User.class)
                    .setProperty(new Property<GitHubPackage, User>() {
                        @Override
                        public User get(GitHubPackage entity) {
                            return entity.owner;
                        }

                        @Override
                        public void set(GitHubPackage entity, User value) {
                            entity.owner = value;
                        }
                    })
                    .setPropertyName("owner")
                    .setPropertyState(new Property<GitHubPackage, PropertyState>() {
                        @Override
                        public PropertyState get(GitHubPackage entity) {
                            return entity.$owner_state;
                        }

                        @Override
                        public void set(GitHubPackage entity, PropertyState value) {
                            entity.$owner_state = value;
                        }
                    })
                    .setGenerated(false)
                    .setReadOnly(false)
                    .setLazy(false)
                    .setNullable(true)
                    .setUnique(false)
                    .setConverter(new com.fastaccess.data.dao.converters.UserConverter())
                    .build();

    public static final NumericAttribute<GitHubPackage, Integer> VERSION_COUNT =
            new AttributeBuilder<GitHubPackage, Integer>("version_count", int.class)
                    .setProperty(new IntProperty<GitHubPackage>() {
                        @Override
                        public Integer get(GitHubPackage entity) {
                            return entity.version_count;
                        }

                        @Override
                        public void set(GitHubPackage entity, Integer value) {
                            entity.version_count = value;
                        }

                        @Override
                        public int getInt(GitHubPackage entity) {
                            return entity.version_count;
                        }

                        @Override
                        public void setInt(GitHubPackage entity, int value) {
                            entity.version_count = value;
                        }
                    })
                    .setPropertyName("version_count")
                    .setPropertyState(new Property<GitHubPackage, PropertyState>() {
                        @Override
                        public PropertyState get(GitHubPackage entity) {
                            return entity.$version_count_state;
                        }

                        @Override
                        public void set(GitHubPackage entity, PropertyState value) {
                            entity.$version_count_state = value;
                        }
                    })
                    .setGenerated(false)
                    .setReadOnly(false)
                    .setLazy(false)
                    .setNullable(false)
                    .setUnique(false)
                    .buildNumeric();

    public static final StringAttribute<GitHubPackage, String> DESCRIPTION =
            new AttributeBuilder<GitHubPackage, String>("description", String.class)
                    .setProperty(new Property<GitHubPackage, String>() {
                        @Override
                        public String get(GitHubPackage entity) {
                            return entity.description;
                        }

                        @Override
                        public void set(GitHubPackage entity, String value) {
                            entity.description = value;
                        }
                    })
                    .setPropertyName("description")
                    .setPropertyState(new Property<GitHubPackage, PropertyState>() {
                        @Override
                        public PropertyState get(GitHubPackage entity) {
                            return entity.$description_state;
                        }

                        @Override
                        public void set(GitHubPackage entity, PropertyState value) {
                            entity.$description_state = value;
                        }
                    })
                    .setGenerated(false)
                    .setReadOnly(false)
                    .setLazy(false)
                    .setNullable(true)
                    .setUnique(false)
                    .buildString();

    public static final StringAttribute<GitHubPackage, String> HTML_URL =
            new AttributeBuilder<GitHubPackage, String>("htmlUrl", String.class)
                    .setProperty(new Property<GitHubPackage, String>() {
                        @Override
                        public String get(GitHubPackage entity) {
                            return entity.htmlUrl;
                        }

                        @Override
                        public void set(GitHubPackage entity, String value) {
                            entity.htmlUrl = value;
                        }
                    })
                    .setPropertyName("htmlUrl")
                    .setPropertyState(new Property<GitHubPackage, PropertyState>() {
                        @Override
                        public PropertyState get(GitHubPackage entity) {
                            return entity.$htmlUrl_state;
                        }

                        @Override
                        public void set(GitHubPackage entity, PropertyState value) {
                            entity.$htmlUrl_state = value;
                        }
                    })
                    .setGenerated(false)
                    .setReadOnly(false)
                    .setLazy(false)
                    .setNullable(true)
                    .setUnique(false)
                    .buildString();

    public static final NumericAttribute<GitHubPackage, Date> UPDATED_AT =
            new AttributeBuilder<GitHubPackage, Date>("updated_at", Date.class)
                    .setProperty(new Property<GitHubPackage, Date>() {
                        @Override
                        public Date get(GitHubPackage entity) {
                            return entity.updated_at;
                        }

                        @Override
                        public void set(GitHubPackage entity, Date value) {
                            entity.updated_at = value;
                        }
                    })
                    .setPropertyName("updated_at")
                    .setPropertyState(new Property<GitHubPackage, PropertyState>() {
                        @Override
                        public PropertyState get(GitHubPackage entity) {
                            return entity.$updated_at_state;
                        }

                        @Override
                        public void set(GitHubPackage entity, PropertyState value) {
                            entity.$updated_at_state = value;
                        }
                    })
                    .setGenerated(false)
                    .setReadOnly(false)
                    .setLazy(false)
                    .setNullable(true)
                    .setUnique(false)
                    .buildNumeric();

    public static final StringAttribute<GitHubPackage, String> NAME =
            new AttributeBuilder<GitHubPackage, String>("name", String.class)
                    .setProperty(new Property<GitHubPackage, String>() {
                        @Override
                        public String get(GitHubPackage entity) {
                            return entity.name;
                        }

                        @Override
                        public void set(GitHubPackage entity, String value) {
                            entity.name = value;
                        }
                    })
                    .setPropertyName("name")
                    .setPropertyState(new Property<GitHubPackage, PropertyState>() {
                        @Override
                        public PropertyState get(GitHubPackage entity) {
                            return entity.$name_state;
                        }

                        @Override
                        public void set(GitHubPackage entity, PropertyState value) {
                            entity.$name_state = value;
                        }
                    })
                    .setGenerated(false)
                    .setReadOnly(false)
                    .setLazy(false)
                    .setNullable(true)
                    .setUnique(false)
                    .buildString();

    public static final StringAttribute<GitHubPackage, String> PACKAGE_TYPE =
            new AttributeBuilder<GitHubPackage, String>("package_type", String.class)
                    .setProperty(new Property<GitHubPackage, String>() {
                        @Override
                        public String get(GitHubPackage entity) {
                            return entity.package_type;
                        }

                        @Override
                        public void set(GitHubPackage entity, String value) {
                            entity.package_type = value;
                        }
                    })
                    .setPropertyName("package_type")
                    .setPropertyState(new Property<GitHubPackage, PropertyState>() {
                        @Override
                        public PropertyState get(GitHubPackage entity) {
                            return entity.$package_type_state;
                        }

                        @Override
                        public void set(GitHubPackage entity, PropertyState value) {
                            entity.$package_type_state = value;
                        }
                    })
                    .setGenerated(false)
                    .setReadOnly(false)
                    .setLazy(false)
                    .setNullable(true)
                    .setUnique(false)
                    .buildString();

    public static final NumericAttribute<GitHubPackage, Date> CREATED_AT =
            new AttributeBuilder<GitHubPackage, Date>("created_at", Date.class)
                    .setProperty(new Property<GitHubPackage, Date>() {
                        @Override
                        public Date get(GitHubPackage entity) {
                            return entity.created_at;
                        }

                        @Override
                        public void set(GitHubPackage entity, Date value) {
                            entity.created_at = value;
                        }
                    })
                    .setPropertyName("created_at")
                    .setPropertyState(new Property<GitHubPackage, PropertyState>() {
                        @Override
                        public PropertyState get(GitHubPackage entity) {
                            return entity.$created_at_state;
                        }

                        @Override
                        public void set(GitHubPackage entity, PropertyState value) {
                            entity.$created_at_state = value;
                        }
                    })
                    .setGenerated(false)
                    .setReadOnly(false)
                    .setLazy(false)
                    .setNullable(true)
                    .setUnique(false)
                    .buildNumeric();

    public static final StringAttribute<GitHubPackage, String> VISIBILITY =
            new AttributeBuilder<GitHubPackage, String>("visibility", String.class)
                    .setProperty(new Property<GitHubPackage, String>() {
                        @Override
                        public String get(GitHubPackage entity) {
                            return entity.visibility;
                        }

                        @Override
                        public void set(GitHubPackage entity, String value) {
                            entity.visibility = value;
                        }
                    })
                    .setPropertyName("visibility")
                    .setPropertyState(new Property<GitHubPackage, PropertyState>() {
                        @Override
                        public PropertyState get(GitHubPackage entity) {
                            return entity.$visibility_state;
                        }

                        @Override
                        public void set(GitHubPackage entity, PropertyState value) {
                            entity.$visibility_state = value;
                        }
                    })
                    .setGenerated(false)
                    .setReadOnly(false)
                    .setLazy(false)
                    .setNullable(true)
                    .setUnique(false)
                    .buildString();

    public static final StringAttribute<GitHubPackage, String> URL =
            new AttributeBuilder<GitHubPackage, String>("url", String.class)
                    .setProperty(new Property<GitHubPackage, String>() {
                        @Override
                        public String get(GitHubPackage entity) {
                            return entity.url;
                        }

                        @Override
                        public void set(GitHubPackage entity, String value) {
                            entity.url = value;
                        }
                    })
                    .setPropertyName("url")
                    .setPropertyState(new Property<GitHubPackage, PropertyState>() {
                        @Override
                        public PropertyState get(GitHubPackage entity) {
                            return entity.$url_state;
                        }

                        @Override
                        public void set(GitHubPackage entity, PropertyState value) {
                            entity.$url_state = value;
                        }
                    })
                    .setGenerated(false)
                    .setReadOnly(false)
                    .setLazy(false)
                    .setNullable(true)
                    .setUnique(false)
                    .buildString();

    public static final Type<GitHubPackage> $TYPE = new TypeBuilder<GitHubPackage>(GitHubPackage.class, "GitHubPackage")
            .setBaseType(AbstractGitHubPackage.class)
            .setCacheable(true)
            .setImmutable(false)
            .setReadOnly(false)
            .setStateless(false)
            .setView(false)
            .setFactory(new Supplier<GitHubPackage>() {
                @Override
                public GitHubPackage get() {
                    return new GitHubPackage();
                }
            })
            .setProxyProvider(new Function<GitHubPackage, EntityProxy<GitHubPackage>>() {
                @Override
                public EntityProxy<GitHubPackage> apply(GitHubPackage entity) {
                    return entity.$proxy;
                }
            })
            .addAttribute(OWNER)
            .addAttribute(PACKAGE_TYPE)
            .addAttribute(VISIBILITY)
            .addAttribute(CREATED_AT)
            .addAttribute(DESCRIPTION)
            .addAttribute(VERSION_COUNT)
            .addAttribute(UPDATED_AT)
            .addAttribute(ID)
            .addAttribute(HTML_URL)
            .addAttribute(URL)
            .addAttribute(NAME)
            .build();

    private PropertyState $id_state;

    private PropertyState $owner_state;

    private PropertyState $version_count_state;

    private PropertyState $description_state;

    private PropertyState $htmlUrl_state;

    private PropertyState $updated_at_state;

    private PropertyState $name_state;

    private PropertyState $package_type_state;

    private PropertyState $created_at_state;

    private PropertyState $visibility_state;

    private PropertyState $url_state;

    private final transient EntityProxy<GitHubPackage> $proxy = new EntityProxy<GitHubPackage>(this, $TYPE);

    protected GitHubPackage(Parcel in) {
        super(in);
    }

    public GitHubPackage() {
    }

    public long getId() {
        return $proxy.get(ID);
    }

    public void setId(long id) {
        $proxy.set(ID, id);
    }

    public User getOwner() {
        return $proxy.get(OWNER);
    }

    public void setOwner(User owner) {
        $proxy.set(OWNER, owner);
    }

    public int getVersion_count() {
        return $proxy.get(VERSION_COUNT);
    }

    public void setVersion_count(int version_count) {
        $proxy.set(VERSION_COUNT, version_count);
    }

    public String getDescription() {
        return $proxy.get(DESCRIPTION);
    }

    public void setDescription(String description) {
        $proxy.set(DESCRIPTION, description);
    }

    public String getHtmlUrl() {
        return $proxy.get(HTML_URL);
    }

    public void setHtmlUrl(String htmlUrl) {
        $proxy.set(HTML_URL, htmlUrl);
    }

    public Date getUpdated_at() {
        return $proxy.get(UPDATED_AT);
    }

    public void setUpdated_at(Date updated_at) {
        $proxy.set(UPDATED_AT, updated_at);
    }

    public String getName() {
        return $proxy.get(NAME);
    }

    public void setName(String name) {
        $proxy.set(NAME, name);
    }

    public String getPackage_type() {
        return $proxy.get(PACKAGE_TYPE);
    }

    public void setPackage_type(String package_type) {
        $proxy.set(PACKAGE_TYPE, package_type);
    }

    public Date getCreated_at() {
        return $proxy.get(CREATED_AT);
    }

    public void setCreated_at(Date created_at) {
        $proxy.set(CREATED_AT, created_at);
    }

    public String getVisibility() {
        return $proxy.get(VISIBILITY);
    }

    public void setVisibility(String visibility) {
        $proxy.set(VISIBILITY, visibility);
    }

    public String getUrl() {
        return $proxy.get(URL);
    }

    public void setUrl(String url) {
        $proxy.set(URL, url);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof GitHubPackage && ((GitHubPackage)obj).$proxy.equals(this.$proxy);
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
