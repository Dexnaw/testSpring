<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-mapping PUBLIC
        "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<hibernate-mapping>

    <meta attribute="class-description">
        Cette classe contient le mapping
    </meta>

    <class name="be.heh.test_spring.BookEntity" table="books" schema="public" catalog="postgres">
        <id name="id" column="id">
            <generator class="native" />
        </id>
        <property name="reader" column="reader"/>
        <property name="isbn" column="isbn"/>
        <property name="title" column="title"/>
        <property name="author" column="author"/>
    </class>
</hibernate-mapping>