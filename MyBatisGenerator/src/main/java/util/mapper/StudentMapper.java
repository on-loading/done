package util.mapper;

import util.mode.Student;

public interface StudentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    int deleteByPrimaryKey(String no);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    int insert(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    int insertSelective(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    Student selectByPrimaryKey(String no);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbggenerated Sat Jul 14 11:21:19 CST 2018
     */
    int updateByPrimaryKey(Student record);
}