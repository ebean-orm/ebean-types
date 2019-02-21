package io.ebean.types;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CdirTest {

  @Test
  public void getAddress() {

    assertEquals("127.0.0.1", new Cdir("127.0.0.1").getAddress());
    assertEquals("2001:db8:85a3:0:0:8a2e:370:7334", new Cdir("2001:db8:85a3:0:0:8a2e:370:7334").getAddress());

    // Inet address ranges
    assertEquals("2001:4f8:3:ba::/64", new Cdir("2001:4f8:3:ba::/64").getAddress());
    assertEquals("2001:4f8:3:ba:2e0:81ff:fe22:d1f1/128", new Cdir("2001:4f8:3:ba:2e0:81ff:fe22:d1f1/128").getAddress());

    // we don't validate the input
    assertEquals("foo", new Cdir("foo").getAddress());
  }

  @Test
  public void equals() {

    assertEquals(new Cdir("foo"), new Cdir("foo"));
    assertEquals(new Cdir("bar"), new Cdir("bar"));

    assertNotEquals(new Cdir("foo"), new Cdir("bar"));
    assertNotEquals(new Cdir("foo"), new Cdir("fo"));
  }

  @Test
  public void testHashCode() {

    assertEquals(new Cdir("foo").hashCode(), new Cdir("foo").hashCode());
    assertEquals(new Cdir("bar").hashCode(), new Cdir("bar").hashCode());

    assertNotEquals(new Cdir("foo").hashCode(), new Cdir("bar").hashCode());
    assertNotEquals(new Cdir("foo").hashCode(), new Cdir("fo").hashCode());
  }

  @Test
  public void test_clone() throws CloneNotSupportedException {

    Cdir inet0 = new Cdir("foo");
    Cdir inet1 = (Cdir)inet0.clone();

    assertEquals(inet0.getAddress(), inet1.getAddress());
  }
}
