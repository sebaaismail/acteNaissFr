package com.sebaainf.ismUtils;

import javax.swing.*;

/**
 * Created by ${sebaainf.com} on 07/11/2015.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */
public class IsmRollBackButton extends JButton {


    private Object old_bean = null;

    public IsmRollBackButton(Object old_bean){
        this.old_bean = old_bean;
    }

    public Object getOld_bean() {

        return old_bean;
    }

    public void setOld_bean(Object old_bean) {

        this.old_bean = old_bean;
    }



}
