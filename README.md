# 2012T06

### 成员名单

- 喻帅
- 刘蕊
- 张旭晨
- 韦吾境
- 时雨

## Component :  Performance Management

### Feature

1. PM
- 接受应用程序的性能指标（名称 ： string， 指标数值 ： int）
- 每分钟自动生成性能报告， 对每个指标求和 
- 性能报告输出到单独文件 （报告文件名为 ： yyyy-mm-dd_hh-mm.log）

2. Lisence
- 每次接受一个请求，计数+1
- 根据已收到请求消息数量和预设的License数值，判断是否可以继续提供服务
	-- 请求数量 <= 预设数量， 返回True
	-- 请求数量 > 预设数量， 返回False

### TODO

- <del>Unit test (with JUnit)</del>
- <del>Documentation</del>
