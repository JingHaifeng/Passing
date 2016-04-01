package com.jinghaifeng.passing.domain;

/**
 * 采用树状模型
 *
 * @author: haifeng jing(haifeng_jing@kingdee.com)
 * @date: 2016-04-01
 * @time: 17:15
 */
public class Task {
    private String mName;

    private long mId;

    private long mCreateTime;
    private long mEndTime;

    private long mSpendTime;

    private boolean isSuccessed;
    private boolean isDeprecated;
}
