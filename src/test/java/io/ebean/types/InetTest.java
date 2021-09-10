package io.ebean.types;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class InetTest {

  @Test
  public void getAddress() {

    assertEquals("127.0.0.1", new Inet("127.0.0.1").getAddress());
    assertEquals("2001:db8:85a3:0:0:8a2e:370:7334", new Inet("2001:db8:85a3:0:0:8a2e:370:7334").getAddress());

    // Inet address ranges
    assertEquals("2001:4f8:3:ba::/64", new Inet("2001:4f8:3:ba::/64").getAddress());
    assertEquals("2001:4f8:3:ba:2e0:81ff:fe22:d1f1/128", new Inet("2001:4f8:3:ba:2e0:81ff:fe22:d1f1/128").getAddress());

    // we don't validate the input
    assertEquals("foo", new Inet("foo").getAddress());
  }

  @Test
  public void equals() {

    assertEquals(new Inet("foo"), new Inet("foo"));
    assertEquals(new Inet("bar"), new Inet("bar"));

    assertNotEquals(new Inet("foo"), new Inet("bar"));
    assertNotEquals(new Inet("foo"), new Inet("fo"));
  }

  @Test
  public void testHashCode() {

    assertEquals(new Inet("foo").hashCode(), new Inet("foo").hashCode());
    assertEquals(new Inet("bar").hashCode(), new Inet("bar").hashCode());

    assertNotEquals(new Inet("foo").hashCode(), new Inet("bar").hashCode());
    assertNotEquals(new Inet("foo").hashCode(), new Inet("fo").hashCode());
  }

  @Test
  public void test_clone() throws CloneNotSupportedException {

    Inet inet0 = new Inet("foo");
    Inet inet1 = (Inet)inet0.clone();

    assertEquals(inet0.getAddress(), inet1.getAddress());
  }

  @Test
  public void test_listOf() {

    List<Inet> inets = Inet.listOf("a", "b");
    assertThat(inets).contains(new Inet("a"), new Inet("b"));
  }

  @Test
  public void test_setOf() {

    Set<Inet> inets = Inet.setOf("a", "b", "a");
    assertThat(inets).contains(new Inet("a"), new Inet("b"));
  }

  @Test
  public void of() {
    assertEquals(Inet.of("foo"), new Inet("foo"));
  }
}
