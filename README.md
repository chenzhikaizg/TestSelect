# TestSelect
RecyclerView如何只选中一条，并显示选中的条目。（The RecyclerView selects only one and displays the selected entry.）
这是运行起来的效果
 ![image](https://github.com/chenzhikaizg/TestSelect/blob/master/app/src/main/res/mipmap-xhdpi/p2.png)
 
 ![image](https://github.com/chenzhikaizg/TestSelect/blob/master/app/src/main/res/mipmap-xhdpi/p1.png)
 
 ![image](https://github.com/chenzhikaizg/TestSelect/blob/master/app/src/main/res/mipmap-xhdpi/p3.png)
默认先将数据获取到，展示在RecyclerView,然后给RecyclerView添加点击事件，在点击事件里面给每个条目设置状态，选中为1，未选中为0.
在adapter的onBindViewHolder（）方法中，设置选中状态的显示。
