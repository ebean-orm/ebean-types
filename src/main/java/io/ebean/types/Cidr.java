package io.ebean.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Cidr address.
 * <p>
 * This is likely only going to be used to map to Postgres CIDR type.
 */
public class Cidr implements Serializable, Cloneable {

  private static final long serialVersionUID = 1;

  private final String address;

  /**
   * Return the list of Cidr addresses.
   */
  public static List<Cidr> listOf(String... addresses) {

    List<Cidr> list = new ArrayList<>(addresses.length);
    for (String address : addresses) {
      list.add(new Cidr(address));
    }
    return list;
  }

  /**
   * Return the set of Cidr addresses.
   */
  public static Set<Cidr> setOf(String... addresses) {
    Set<Cidr> set = new LinkedHashSet<>();
    for (String address : addresses) {
      set.add(new Cidr(address));
    }
    return set;
  }

  /**
   * Return the Cidr address.
   * <p>
   * Equivalent to using the constructor and here as alternate style.
   */
  public static Cidr of(String address) {
    return new Cidr(address);
  }

  /**
   * Create with a given address.
   */
  public Cidr(String address) {
    this.address = address;
  }

  /**
   * Return the address.
   */
  public String address() {
    return address;
  }

  /**
   * Deprecated migrate to address().
   */
  @Deprecated
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
    Cidr inet = (Cidr) o;
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
