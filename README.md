# feigong
我们在做Web项目的时候花费大量时间都用在 表单/json/Bean 的后端验证上，因为我们要确保
web后端数据的安全性和一致性，同时给用户一个友好的提醒

用过Struts，Spring，JFinal的朋友应该知道，它们的提供的命令式Validator体系设计都十分
优秀，但往往不省时间

而注解式Validator其缺点显而易见

1.不够直观，不够集中

2.对Bean产生入侵，也使一Bean多验证逻辑混乱

3.灵活性差，难以驾驭复杂的验证逻辑


因此我一直在思考如何提炼出简洁的Validator


以下是我提出的一种命令式验证手段 - 非攻，启发自Laravel的表单验证，但我想，它
会比Laravel更灵活好用得多


 **公输盘之攻械尽，子墨子之守圉有余** 


我想实现的正是简单的代码对付不合法的数据输入甚至恶意攻击游刃有余


#### 项目介绍

```java
 Map map=new HashMap();
        String[] tags={"生活","人文","社会"};
        map.put("num",31415);
        map.put("title","标题");
        map.put("tags",tags);

/*
以下是最简单的使用例子
更多已有功能和待完善的功能将在后续文档中补全
*/
        Err err=asMap(
                val("num").checkers(asInt(min(1000),max(9999))),
                val("title").checkers(asStr(length(3,10))),
                val("tags").checkers(asList(
                            each().checkers(in("生活","科技")),
                            size(0,10)
                ))
        ).check(map);

```


此项目正在起步阶段，诸多不完善，且本人水平有限，请OSC的各位大神不吝赐教
