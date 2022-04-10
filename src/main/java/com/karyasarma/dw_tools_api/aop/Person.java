package com.karyasarma.dw_tools_api.aop;

import org.hibernate.validator.constraints.Length;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class Person implements ValidatorRedisKey
{
    @Length(max = 10)
    private String name;

    public Person()
    {
    }

    @Override
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
