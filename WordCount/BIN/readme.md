wc.exe文件可在安装了JVM的机器上运行，不再要求其他环境
可在命令行打开运行，主要命令如下：
wc.exe -l file.c       //统计file.c中的行数
wc.exe -c file.c     //统计file.c中的字符数
wc.exe -w file.c     //统计单词数
wc.exe [参数]  -o output.txt   //指定输出到output.txt文件中

以上位基础功能，拓展功能如下：

wc.exe -a file.c     //返回更复杂的数据（代码行 / 空行 / 注释行）
wc.exe -e stopList.txt  // 停用词表，统计文件单词总数时，不统计该表中的单词

  // -e 必须与停用词文件名同时使用，且停用词文件必须紧跟在-e参数后面，不允许单独使用-e参数。
   //stopList.txt中停用词可以多于1个，单词之间以空格分割，不区分大小写

wc.exe -s            //递归处理目录下符合条件的文件
  此项内容未实现