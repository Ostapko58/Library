package com.onyshkiv.DAO;

public abstract class SQLQuery {
    static class BookQuery{
        public static final String SELECT_ALL_BOOKS ="select book.*,authors.*,publication.* " +
                "from book, authors, book_has_authors,publication " +
                "where book.isbn=book_has_authors.b_isbn and  book_has_authors.a_id = authors.authors_id and publication.publication_id=book.publication_id";
        public static final String SELECT_BOOK_BY_ISBN ="select book.*,authors.*,publication.* " +
                "from book, authors, book_has_authors,publication " +
                "where book.isbn=book_has_authors.b_isbn and  book_has_authors.a_id = authors.authors_id and publication.publication_id=book.publication_id and book.isbn=?";
    }

    static class UserQuery{
        public static final String SELECT_ALL_USERS ="select u.login, u.email, u.password,r.name as `role`,s.name as `status`, u.first_name,u.last_name, u.phone\n" +
                "from user u\n" +
                "left join role r using(role_id)\n" +
                "left join user_status s on user_status_id = status_id ";
        public static final String SELECT_ALL_USERS_BY_ACTIVE_BOOK ="select u.login, u.email, u.password,r.name as `role`,s.name as `status`, u.first_name,u.last_name, u.phone \n" +
                "from user u\n" +
                "left join role r using(role_id)\n" +
                "left join user_status s on user_status_id = status_id\n" +
                "left join active_book_has_user abhu on user_login = login\n" +
                "where u.login=abhu.user_login and abhu.active_book_id =?";
        public static final String SELECT_USER_BY_LOGIN ="select u.login, u.email, u.password,r.name as `role`,s.name as `status`, u.first_name,u.last_name, u.phone\n" +
                "from user u\n" +
                "left join role r using(role_id)\n" +
                "left join user_status s on user_status_id = status_id " +
                "WHERE login = ?";
        public static final String INSERT_USER="INSERT INTO user values\n" +
                "(?,?,?,?,?,?,?,?);";
        public static  final String UPDATE_USER = "UPDATE user SET email=?,password=?,role_id=?,status_id=?,first_name=?,last_name=?,phone=? \n" +
                "WHERE login = ?";
        public static  final String DELETE_USER ="DELETE FROM user WHERE login = ?";
    }

    static class ActiveBookQuery{
        public static  final String  SELECT_ALL_ACTIVE_BOOKS  = "Select actb.active_book_id,actb.book_isbn, wou.name,sub_st.name, actb.start_date, actb.end_date,fine\n" +
                "from active_book actb\n" +
                "left join way_of_using wou using(way_of_using_id)\n" +
                "left join subscription_status sub_st using(subscription_status_id);";
        public static  final String  SELECT_ACTIVE_BOOK_BY_ID  = "Select actb.active_book_id,actb.book_isbn, wou.name,sub_st.name, actb.start_date, actb.end_date,fine\n" +
                "from active_book actb\n" +
                "left join way_of_using wou using(way_of_using_id)\n" +
                "left join subscription_status sub_st using(subscription_status_id) " +
                "where actb.active_book_id=?";
        public static final String INSERT_ACTIVE_BOOK = "Insert Into active_book values\n" +
                "(default,?,?,?,?,?,?);";
        public static final String UPDATE_ACTIVE_BOOK ="UPDATE active_book SET book_isbn=?,way_of_using_id=?,subscription_status_id=?,start_date=?,end_date=?,fine=? " +
                "WHERE active_book_id=?";
        public static final String DELETE_ACTIVE_BOOK = "DELETE FROM active_book WHERE active_book_id =?";
    }
}
