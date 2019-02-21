package io.ebean.types;

import java.io.Serializable;
import java.util.Objects;

/**
 * An Cdir address.
 * <p>
 * This is likely only going to be used to map to Postgres CDIR type.
 */
public class Cdir implements Serializable, Cloneable {

  private static final long serialVersionUID = 1;

  private final String address;

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
