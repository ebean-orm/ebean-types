package io.ebean.types;

import java.io.Serializable;
import java.util.Objects;

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
