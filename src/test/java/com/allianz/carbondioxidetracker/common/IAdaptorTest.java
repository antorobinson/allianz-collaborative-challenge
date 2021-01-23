package com.allianz.carbondioxidetracker.common;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IAdaptorTest {

    AdaptorImpl adaptor ;

    @Before
    public void setUp() {

        adaptor = new AdaptorImpl() ;
    }

    @Test
    public void testAdoptNullListInput() {


        final List<PUser> pUserList = null ;

        final List<DUser> dUserList = adaptor.adopt(pUserList) ;

        Assertions.assertThat(dUserList).isNotNull();
        Assertions.assertThat(dUserList.isEmpty()).isTrue();
    }

    @Test
    public void testAdoptEmptyListInput() {


        final List<PUser> pUserList = new ArrayList<>() ;

        final List<DUser> dUserList = adaptor.adopt(pUserList) ;

        Assertions.assertThat(dUserList).isNotNull();
        Assertions.assertThat(dUserList.isEmpty()).isTrue();
    }

    @Test
    public void testAdoptNullListValuesInput() {

        final PUser pUser = null ;

        final List<PUser> pUserList = new ArrayList<>() ;
        pUserList.add(pUser) ;
        pUserList.add(pUser) ;

        final List<DUser> dUserList = adaptor.adopt(pUserList) ;

        Assertions.assertThat(dUserList).isNotNull();
        Assertions.assertThat(dUserList.isEmpty()).isTrue();
    }

    @Test
    public void testAdoptList() {

        final PUser pUser = new PUser("T T Marshel", 32) ;

        final List<PUser> pUserList = new ArrayList<>() ;
        pUserList.add(pUser) ;
        pUserList.add(pUser) ;

        final List<DUser> dUserList = adaptor.adopt(pUserList) ;

        Assertions.assertThat(dUserList).isNotNull();
        Assertions.assertThat(dUserList.size()).isEqualTo(2);
        Assertions.assertThat(dUserList.get(0).getUserName()).isEqualTo(pUserList.get(0).getName());
        Assertions.assertThat(dUserList.get(0).getUserAge()).isEqualTo(pUserList.get(0).getAge());
        Assertions.assertThat(dUserList.get(1).getUserName()).isEqualTo(pUserList.get(1).getName());
        Assertions.assertThat(dUserList.get(1).getUserAge()).isEqualTo(pUserList.get(1).getAge());
    }

    private static class PUser {

        private final String name;
        private final int age;

        private PUser(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    private static class DUser {

        private final String userName;
        private final int userAge;

        public DUser(String userName, int userAge) {
            this.userName = userName;
            this.userAge = userAge;
        }

        public String getUserName() {
            return userName;
        }

        public int getUserAge() {
            return userAge;
        }
    }

    private static class AdaptorImpl implements IAdaptor<PUser, DUser> {


        @Override
        public DUser adopt(PUser user) {

            if (user == null) return null ;
            return new DUser(user.getName(), user.getAge());
        }
    }
}
