package io.ebean.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * An Inet address or IP address range.
 * <p>
 * The value is intentionally not validated allowing use with IpV6 internet address ranges.
 * That is, we can use this for not only IpV4 and IpV6 internet addresses but ranges as well.
 */
public class Inet implements Serializable, Cloneable {

  private static final long serialVersionUID = 1;

  private final String address;

  /**
   * Return the list of Inet addresses.
   */
  public static List<Inet> listOf(String... addresses) {
    List<Inet> list = new ArrayList<>(addresses.length);
    for (String address : addresses) {
      list.add(new Inet(address));
    }
    return list;
  }

  /**
   * Return the set of Inet addresses.
   */
  public static Set<Inet> setOf(String... addresses) {
    Set<Inet> set = new LinkedHashSet<>();
    for (String address : addresses) {
      set.add(new Inet(address));
    }
    return set;
  }

  /**
   * Return the Inet address.
   * <p>
   * Equivalent to using the constructor and here as alternate style.
   */
  public static Inet of(String address) {
    return new Inet(address);
  }

  /**
   * Create with a given address.
   * <p>
   * The address can contain anything with the intention of supporting ip address
   * ranges and the like.  For example, <code>2001:4f8:3:ba::/64</code> and
   * <code>2001:4f8:3:ba:2e0:81ff:fe22:d1f1/128</code>
   */
  public Inet(String address) {
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
    Inet inet = (Inet) o;
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
