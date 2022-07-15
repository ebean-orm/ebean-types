package io.ebean.types;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CidrTest {

  @Test
  void getAddress() {
    assertEquals("127.0.0.1", new Cidr("127.0.0.1").address());
    assertEquals("2001:db8:85a3:0:0:8a2e:370:7334", new Cidr("2001:db8:85a3:0:0:8a2e:370:7334").address());

    // Inet address ranges
    assertEquals("2001:4f8:3:ba::/64", new Cidr("2001:4f8:3:ba::/64").address());
    assertEquals("2001:4f8:3:ba:2e0:81ff:fe22:d1f1/128", new Cidr("2001:4f8:3:ba:2e0:81ff:fe22:d1f1/128").address());

    // we don't validate the input
    assertEquals("foo", new Cidr("foo").address());
  }

  @Test
  void equals() {
    assertEquals(new Cidr("foo"), new Cidr("foo"));
    assertEquals(new Cidr("bar"), new Cidr("bar"));

    assertNotEquals(new Cidr("foo"), new Cidr("bar"));
    assertNotEquals(new Cidr("foo"), new Cidr("fo"));
  }

  @Test
  void testHashCode() {
    assertEquals(new Cidr("foo").hashCode(), new Cidr("foo").hashCode());
    assertEquals(new Cidr("bar").hashCode(), new Cidr("bar").hashCode());

    assertNotEquals(new Cidr("foo").hashCode(), new Cidr("bar").hashCode());
    assertNotEquals(new Cidr("foo").hashCode(), new Cidr("fo").hashCode());
  }

  @Test
  void test_clone() throws CloneNotSupportedException {
    Cidr inet0 = new Cidr("foo");
    Cidr inet1 = (Cidr)inet0.clone();

    assertEquals(inet0.address(), inet1.address());
  }

  @Test
  void test_listOf() {
    List<Cidr> addrs = Cidr.listOf("a", "b");
    assertThat(addrs).contains(new Cidr("a"), new Cidr("b"));
  }

  @Test
  void test_setOf() {
    Set<Cidr> addrs = Cidr.setOf("a", "b", "a");
    assertThat(addrs).contains(new Cidr("a"), new Cidr("b"));
  }

  @Test
  void of() {
    assertEquals(Cidr.of("foo"), new Cidr("foo"));
  }

}
