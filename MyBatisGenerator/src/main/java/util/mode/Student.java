package util.mode;

import java.util.Date;

public class Student {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column students.NO
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    private String no;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column students.name
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column students.sex
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column students.birthday
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    private Date birthday;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    public Student(String no, String name, String sex, Date birthday) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    public Student() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column students.NO
     *
     * @return the value of students.NO
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    public String getNo() {
        return no;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column students.NO
     *
     * @param no the value for students.NO
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column students.name
     *
     * @return the value of students.name
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column students.name
     *
     * @param name the value for students.name
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column students.sex
     *
     * @return the value of students.sex
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column students.sex
     *
     * @param sex the value for students.sex
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column students.birthday
     *
     * @return the value of students.birthday
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column students.birthday
     *
     * @param birthday the value for students.birthday
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}