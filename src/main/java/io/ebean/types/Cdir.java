package io.ebean.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * An Cdir address.
 * <p>
 * This is likely only going to be used to map to Postgres CDIR type.
 */
public class Cdir implements Serializable, Cloneable {

  private static final long serialVersionUID = 1;

  private final String address;

  /**
   * Return the list of Cdir addresses.
   */
  public static List<Cdir> listOf(String... addresses) {

    List<Cdir> list = new ArrayList<>(addresses.length);
    for (String address : addresses) {
      list.add(new Cdir(address));
    }
    return list;
  }

  /**
   * Return the set of Cdir addresses.
   */
  public static Set<Cdir> setOf(String... addresses) {
    Set<Cdir> set = new LinkedHashSet<>();
    for (String address : addresses) {
      set.add(new Cdir(address));
    }
    return set;
  }

  /**
   * Return the Cdir address.
   * <p>
   * Equivalent to using the constructor and here as alternate style.
   */
  public static Cdir of(String address) {
    return new Cdir(address);
  }

  /**
   * Create with a given address.
   */
  public Cdir(String address) {
    this.address = address;
  }

  /**
   * Return the address.
   */
  public String getAddress() {
    return address;
  }

  @Override
  public String toString() {
    return address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cdir inet = (Cdir) o;
    return Objects.equals(address, inet.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address);
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
