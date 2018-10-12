package com.hisptz.hris.Bundles.FormBundle;

/**
 * Created by Guest on 8/14/18.
 */
import com.hisptz.hris.Bundles.UserBundle.User;
import com.hisptz.hris.core.Model.main.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "form")
public class Form extends Model {
    private String name;
    private String hypertext;
    private String title;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {
                    CascadeType.PERSIST,
                        CascadeType.MERGE
                })
    @JoinTable(name = "user_formmembers",
            joinColumns = {@JoinColumn(name = "form_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> userId = new HashSet<User>();

    public Form() {
        super();
    }

    public Form(String uid, String name, String hypertext, String title) {
        super();
        this.name = name;
        this.hypertext = hypertext;
        this.title = title;
    }

    @Basic
    @Column(name = "uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "hypertext")
    public String getHypertext() {
        return hypertext;
    }

    public void setHypertext(String hypertext) {
        this.hypertext = hypertext;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}