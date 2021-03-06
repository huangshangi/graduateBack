/*
 * Copyright (c) 2020
 * Date:2020/06/12 11:39:12
 * Author:huangshangi
 * explain:教师招生资格基本信息
 *
 */

package com.sdu.graduateback.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

//import com.sun.istack.internal.NotNull;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecuritQualification {


    private String id;//工号

    private String pc;//论文数

    private String bc;//专著数

    private String ac;//获奖数

    private String ic;//专利数

    private String tc;//总费用

    private String dc;//可支配费用数

    private String nc;//国家项目数

    private String npc;//国家立项数

    private String ppc;//省级项目数

    private String nppc;//省级立项数

    private String cpc;//横向项目数

    private String dsc;//找到博士生数

    private String msc;//指导硕士生数

    private String hgdsc;//协助指导博士生数

    private String loma;//已申请列表

    private String nloma;//未申请列表

    //以下字段不应储存在数据库中
    private String token;

    private String t;

    private String tId;

    public static RecuritQualification getJsonResult(String id, String pc, String bc, String ac,
                                              String ic, String tc, String dc, String nc,
                                              String npc, String ppc, String nppc, String cpc,
                                              String dsc, String msc, String hgdsc) {

        return new RecuritQualification(id,pc,bc,ac,ic,tc,dc,nc,npc,ppc,nppc,cpc,dsc,
                msc,hgdsc,null,null,null,null,null);
    }


    public static RecuritQualification getJsonResult(RecuritQualification recuritQualification){

        return getJsonResult(recuritQualification.getId(),recuritQualification.getPc(),recuritQualification.getBc(),
                recuritQualification.getAc(),recuritQualification.getIc(),recuritQualification.getTc(),recuritQualification.getDc(),recuritQualification.getNc(),
                recuritQualification.getNpc(),recuritQualification.getPpc(),recuritQualification.getNppc(),recuritQualification.getCpc(),
                recuritQualification.getDsc(),recuritQualification.getMsc(),recuritQualification.getHgdsc());
    }

    public RecuritQualification(String id, String pc, String bc, String ac, String ic,
                                String tc, String dc, String nc, String npc, String ppc,
                                String nppc, String cpc, String dsc, String msc, String hgdsc,
                                String loma, String nloma, String token, String t, String tId) {
        this.id = id;
        this.pc = pc;
        this.bc = bc;
        this.ac = ac;
        this.ic = ic;
        this.tc = tc;
        this.dc = dc;
        this.nc = nc;
        this.npc = npc;
        this.ppc = ppc;
        this.nppc = nppc;
        this.cpc = cpc;
        this.dsc = dsc;
        this.msc = msc;
        this.hgdsc = hgdsc;
        this.loma = loma;
        this.nloma = nloma;
        this.token = token;
        this.t = t;
        this.tId = tId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getBc() {
        return bc;
    }

    public void setBc(String bc) {
        this.bc = bc;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getNc() {
        return nc;
    }

    public void setNc(String nc) {
        this.nc = nc;
    }

    public String getNpc() {
        return npc;
    }

    public void setNpc(String npc) {
        this.npc = npc;
    }

    public String getPpc() {
        return ppc;
    }

    public void setPpc(String ppc) {
        this.ppc = ppc;
    }

    public String getNppc() {
        return nppc;
    }

    public void setNppc(String nppc) {
        this.nppc = nppc;
    }

    public String getCpc() {
        return cpc;
    }

    public void setCpc(String cpc) {
        this.cpc = cpc;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public String getMsc() {
        return msc;
    }

    public void setMsc(String msc) {
        this.msc = msc;
    }

    public String getHgdsc() {
        return hgdsc;
    }

    public void setHgdsc(String hgdsc) {
        this.hgdsc = hgdsc;
    }

    public String getLoma() {
        return loma;
    }

    public void setLoma(String loma) {
        this.loma = loma;
    }

    public String getNloma() {
        return nloma;
    }

    public void setNloma(String nloma) {
        this.nloma = nloma;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }
}
