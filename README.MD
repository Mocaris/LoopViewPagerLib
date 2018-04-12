### 无限轮播ViewPagerAdapter
#可以无限轮播  两种方式  参考demo写法

* 设置getCount 为int 最大值   设置显示item为中间值
* 添加list最后一个item到第一位,添加list第一个item到最后一位,根据滚动监听设置当前item