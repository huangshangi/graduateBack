/*
 * Copyright (c) 2020
 * Date:2020/06/18 16:54:18
 * Author:huangshangi
 * explain:教师招生团队申请
 *
 */

package com.sdu.graduateback.mapper;

import com.sdu.graduateback.dto.Team;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamMapper {

    Team getTeamById(String id);

    int updateTeam(Team team);
    int updateMember(String tid,String id);

    int addTeam(Team team);

    int deleteTeam(Team team);

}
