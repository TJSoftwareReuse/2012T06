# Team 成员查询 Server 项目文档

负责队伍 ： Team 6

项目版本： 5.0

## 功能说明

### 基本功能

作为 Server 接受 Team 的名称， 对数据文件进行查询， 返回查到的该 Team 所有成员的姓名。

### 新增功能

- 支持动态时间段输出性能报告
	- 输出时间段可配置
	- 性能文件名称包含起始时间和结束时间
- 支持配置动态加载，并应用到相关模块， 包括：
	- FM文件路径
	- PM文件路径
	- PM输出时间间隔
	- License数量

## 依赖

- [配置管理（CM）](https://github.com/TJSoftwareReuse/DeliverComponents/tree/master/CM/T1)
- [告警管理（FM）](https://github.com/TJSoftwareReuse/DeliverComponents/tree/master/FM/T3)
- [性能管理（PM）](https://github.com/TJSoftwareReuse/2012T06/blob/master/Project/ReusableServerV5.0/src/com/Team06/PM.java)
- [许可证（License）](https://github.com/TJSoftwareReuse/DeliverComponents/tree/master/License/T4)


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

**当前每次Server启动都会自动打印测试数据， 即本班同学的分组数据**


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

此统计仅在有请求的时候才会触发， 统计的时间粒度**默认**为**1分钟**， 每个时间段完成统计后生成日志文件， 存储地址**默认**为项目根目录， 文件格式是： **YYYY-MM-DD_HH-MM-YYYY-MM-DD_HH-MM.log**(文件名代表该统计的起始时间和结束时间)

在 3.5 的版本中， 开始支持统计时间间隔和日志输出路径的动态配置。 为了完成这些功能， Server 提供了以下公共方法以便调用：

    public void setPMSettings(long newInterval, String newPath)

其中：
- 通过参数 `newInterval`设置新的时间间隔，单位为秒
- 通过参数`newPath`设置新的文件输出路径， 该路径需要是绝对路径
- 该方法中， `newPath`为可选参数


### 告警管理

在3.5版本的 Server 中， 提供了 FM 的日志路径配置方法以动态改变 FM 的日志输出路径：

    public void setFMSettings(String newPath)

设置成功后， 下一条警告将切换到新文件


### 许可证

在3.5版本的 Server 中， 提供了重置 License 数量的方法， 重置后， 从 0 开始重新计数：

    resetLicense(int newNum)



## Changelog

### V 5.0
- License模块替换为Team4开发的版本

### V 3.5

- 支持动态时间段输出性能报告
	- 输出时间段可配置
	- 性能文件名称包含起始时间和结束时间
- 支持配置动态加载，并应用到相关模块， 包括：
	- FM文件路径
	- PM文件路径
	- PM输出时间间隔
	- License数量

### V 3.0

- 连接 : 上一版本的 Server 在每一次查询之后会自动断开连接， 而这一版本会保持连接， 直到 Client 断开连接为止。
- 编码 : 解决了远程传输中文会乱码的问题。
