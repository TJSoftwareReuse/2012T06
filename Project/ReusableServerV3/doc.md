# Team 名称查询 Server 项目文档

负责队伍 ： Team 6
项目版本： 3.0

## 功能说明

作为 Server 接受 Team 的名称， 对数据文件进行查询， 返回查到的该 Team 所有成员的姓名。

## 依赖

- [配置管理（CM）](https://github.com/TJSoftwareReuse/DeliverComponents/tree/master/CM/T1)
- [告警管理（FM）](https://github.com/TJSoftwareReuse/DeliverComponents/tree/master/FM/T3)
- [性能管理（PM）](https://github.com/TJSoftwareReuse/DeliverComponents/tree/master/PM/T6/1.0)
- [许可证（License）](https://github.com/TJSoftwareReuse/DeliverComponents/tree/master/License/T6/1.0)

## 使用

### 导入数据

本程序使用单文件存储数据， 包括队员名称及其所属队伍。 

在程序根目录 `/` 创建 `settings.txt` , 是为程序默认保存数据的位置。

对于一个队员的数据， 格式规定为：

- 队员名称： **MemberName_*N*=*Name***
	
	N 为该队员ID, Name为名字（由于编码问题， 中文需使用Unicode）

- 队员所属团队： **Member_Team_*N*=*Team_ID***

	N 表示该队员 ID， Team_ID为其所属队伍 ID

例如：

    MemberName_1=\u5434\u9038\u83F2  
    Member_Team_1=1
    
表示吴逸菲的 ID 为 1 ， 她所属的Team 的编号为 1。

在[这里](https://github.com/TJSoftwareReuse/2012T06/blob/master/Project/ReusableServer/settings.txt)可以看到一个完整的例子。


###  用户查询

- Socket 监听端口： 3999
- 查询： 
	- 输入 Team 名称（任意String）
	- 如果 License 过期， 将收到 FM 警告 ：
			Reject due to license expiration
	- 如果 License 正常， 并查到输入的结果， 则可得到返回 ：
			Members: Members name
	- 如果查询不到结果， 则返回：
			Group GroupName not found


### 性能管理

本项目使用 PM 组件进行性能管理， 统计的范围包括：

- 接收信息数 `ReceivedMessages`
- 接受请求数 `AcceptedRequests`
- 拒绝请求数 `RejectedRequests`
- 回复信息数 `ResponseMessages`

此统计仅在有请求的时候才会触发， 统计的时间粒度为**1分钟**， 每分钟完成统计后生成日志文件， 存储地址为项目根目录， 文件格式是： **YYYY-MM-DD_HH-MM.log**


## 相较上一版本的改变

### 连接

这一版本的 Server 复用了上一版本的大部分代码， 主要的区别在于： 上一版本的 Server 在每一次查询之后会自动断开连接， 而这一版本会保持连接， 直到 Client 断开连接为止。

### 编码

解决了远程传输中文会乱码的问题。