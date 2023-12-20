package com.fly.test.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

//    @Mappings({
//            @Mapping(source = "name", target = "nameVo"),
//            @Mapping(source = "age", target = "ageVo")
//    })
//    StudentVO toStudentVO(Student student);

    @Mappings({
            @Mapping(source = "teacher.teacherName", target = "nameVo"),
            @Mapping(source = "student.age", target = "ageVo")
    })
    StudentVO toStudentVO(Student student, Teacher teacher);

}
