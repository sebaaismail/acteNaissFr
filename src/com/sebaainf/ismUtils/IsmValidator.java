package com.sebaainf.ismUtils;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.value.AbstractValueModel;
import com.jgoodies.binding.value.ValueHolder;
import com.jgoodies.validation.ValidationResult;
import com.jgoodies.validation.Validator;
import com.sebaainf.acteNaissFr.common.MyApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ${sebaainf.com} on 04/04/2015.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */
public abstract class IsmValidator implements Validator<Object> {

    protected ValidationResult validationResult = new ValidationResult();
    protected PresentationModel preModel;

    /**
     * method to add blank error , property can be String or int
     *
     * @param propertyName
     * @param propertyText text shown in the error message
     */
    protected void addBlankError(String propertyName, String propertyText) {



        String blankErrorMessage = " قم بملاء خانة";
        boolean flag = false;
        AbstractValueModel value = this.preModel.getModel(propertyName);

        String typeClass = value.getValue().getClass().getSimpleName();

        if (typeClass.equals("String")) {
            if (value.getValue().equals("")) flag = true;

        } else if (typeClass.equals("Date")) {

            if (value.getValue().equals(MyApp.defaultDate)) flag = true;
            System.out.println("date is =" + value.getValue());

        } else if (typeClass.equals("Timestamp")) {

            if (value.getValue().equals(null)) flag = true;
            System.out.println("date is =" + value.getValue());

        } else if (typeClass.equals("Integer")) {
        	if(value.intValue() == 0) flag = true;
        }else if (typeClass.equals("Long")) {
        	if(value.longValue() == 0) flag = true;
        }


        if (flag) {
            validationResult.addError(blankErrorMessage + " " + propertyText);
        }


    }

    @Override
    public abstract ValidationResult validate(Object o);
    public abstract ValidationResult validateForSearch(Object o);

}
