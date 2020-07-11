get
get是获取资源，get是安全并且是幂等的，意思是用相同的url和参数，获取的结果是一样的。如果正确获得资源，应该返回200(OK)状态码。

post用来创建和更新资源，post是不安全并且不是幂等的。

参考：https://blog.csdn.net/nwj_03/java/article/details/100347668