/*
 * Copyright (c) 2020
 * Date:2020/06/16 13:18:16
 * Author:huangshangi
 * explain:
 *
 */

package com.sdu.graduateback.service;

import com.sdu.graduateback.dto.Thesis;

import java.util.List;

public interface ThesisService {

    int addThesis(Thesis thesis);

    int deleteThesis(Thesis thesis);

    int updateThesis(Thesis thesis);


    List<Thesis> getThesisWai(String id);

    List<Thesis> getThesisBi(String id);


    Object thesisPack(List<Thesis>list);


}
