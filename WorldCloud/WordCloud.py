#coding=utf-8
#这些包要先安装
import matplotlib.pyplot as plt
from wordcloud import WordCloud

import jieba

#打开文件
text = open('wordcloud.txt').read()

#用jieba进行词的切分
wordlist_after_jieba = jieba.cut(text, cut_all=True)
wl_space_split =  " ".join(wordlist_after_jieba)

#WordCloud（）可以设置词云图的参数，字体如果不设无法显示中文
my_wordcloud = WordCloud(font_path='C:/Python27/Lib/site-packages/pytagcloud/fonts/simhei.ttf').generate(wl_space_split)

plt.imshow(my_wordcloud)
plt.axis("off")
plt.show()