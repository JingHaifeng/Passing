package com.jinghaifeng.passing.domain;

/**
 * 采用树状模型
 *
 * @author: haifeng jing(haifeng_jing@kingdee.com)
 * @date: 2016-04-01
 * @time: 17:15
 */
public class Task {

    public static final int NONE_ID = -1;
    public static final int NONE_TIME = -1;

    // 初始化容量，及增长量
    private static final int ARRAY_INITIAL_CAPACITY = 12;
    private static final int ARRAY_CAPACITY_INCREMENT = 12;

    private String mName;

    private long mId = NONE_ID;

    private long mCreateTime = NONE_TIME;

    private Task mParent;

    // 子任务数组
    private Task[] mChildren;
    // 子任务的数目
    private int mChildrenCount;

    public Task() {
    }

    private void initTask() {
        mChildren = new Task[ARRAY_INITIAL_CAPACITY];
        mChildrenCount = 0;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public long getCreateTime() {
        return mCreateTime;
    }

    public void setCreateTime(long createTime) {
        mCreateTime = createTime;
    }

    public Task getParent() {
        return mParent;
    }

    public void setParent(Task parent) {
        mParent = parent;
    }

    public void addChild(Task child) {
        addChild(child, -1);
    }

    public void addChild(Task child, int index) {

        if (index < 0) {
            index = mChildrenCount;
        }

        Task[] children = mChildren;
        final int count = mChildrenCount;
        final int size = mChildren.length;

        if (index == count) {
            if (size == count) {
                mChildren = new Task[size + ARRAY_CAPACITY_INCREMENT];
                System.arraycopy(children, 0, mChildren, 0, size);
                children = mChildren;
            }
            children[mChildrenCount++] = child;
        } else if (index < count) {
            if (size == count) {
                mChildren = new Task[size + ARRAY_CAPACITY_INCREMENT];
                System.arraycopy(children, 0, mChildren, 0, index);
                System.arraycopy(children, index, mChildren, index + 1, count - index);
                children = mChildren;
            } else {
                System.arraycopy(children, index, children, index + 1, count - index);
            }
            children[index] = child;
            mChildrenCount++;
        } else {
            throw new IndexOutOfBoundsException("index=" + index + " count=" + count);
        }
    }

    public static void main(String[] args) {
        Task root = new Task();
        root.setName("root");
        root.setId(0);
        root.setCreateTime(System.currentTimeMillis());

        for (int i = 1;i < 10;i++ ) {
            Task c1 = new Task();
            c1.setName("child:"+i);
            c1.setId(i);
            c1.setCreateTime(System.currentTimeMillis());
            for (int j = 10 ; j < 20;j++) {
                Task c2 = new Task();
                c2.setName("child:"+j);
                c2.setId(j);
                c2.setCreateTime(System.currentTimeMillis());
            }
        }
    }
}
