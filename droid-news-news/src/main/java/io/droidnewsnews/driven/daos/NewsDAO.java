package io.droidnewsnews.driven.daos;

import io.droidnewsnews.core.domain.entities.UserEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "news")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public final class NewsDAO implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "hat", length = 20)
  private String hat;

  @Column(name = "title", length = 100, nullable = false)
  private String title;

  @Column(name = "caption", length = 200, nullable = false)
  private String caption;

  @Column(name = "body", length = 10000, nullable = false)
  private String body;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "curso_id")
  private List<NewsUserDAO> newsUsers = new ArrayList<>();

  @Transient
  private List<UserEntity> users = new ArrayList<>();

  public void addNewsUser(NewsUserDAO user) {
    this.newsUsers.add(user);
  }

  public void removeNewsUser(NewsUserDAO user) {
    this.newsUsers.remove(user);
  }
}

