# mongodb

RDBMS vs NoSQL RDBMS

- 高度组织化结构化数据
- 结构化查询语言（SQL） (SQL)
- 数据和关系都存储在单独的表中。
- 数据操纵语言，数据定义语言
- 严格的一致性
- 基础事务

NoSQL

- 代表着不仅仅是SQL
- 没有声明性查询语言
- 没有预定义的模式 -键 - 值对存储，列存储，文档存储，图形数据库
- 最终一致性，而非ACID属性
- 非结构化和不可预知的数据
- CAP定理
- 高性能，高可用性和可伸缩性

## CAP定理 CAP theorem

在计算机科学中, CAP定理（CAP theorem）, 又被称作 布鲁尔定理（Brewer's theorem）, 它指出对于一个分布式计算系统来说，不可能同时满足以下三点:

- 一致性(Consistency) (所有节点在同一时间具有相同的数据)
- 可用性(Availability) (保证每个请求不管成功或者失败都有响应)
- 分隔容忍(Partition tolerance) (系统中任意信息的丢失或失败不会影响系统的继续运作)

## 概念

sql database -> table -> row -> column 表联合

mongo database -> collection -> document -> field 嵌入

## 命令

### database

show dbs 显示所有数据库

use test 使用test数据库

db 显示当前使用的数据库

db.dropDatabase() 删除当前数据库

### collection

db.createCollection(name, options) db.createCollection('user')

db.collection_name.drop() db.user.drop()

### document

#### insert/save

db.collection_name.insert(document) db.user.insert({username:'username',password:'password'})

db.collection_name.save(document)

#### delete

db.collection_name.deleteMany(query, ...) db.user.deleteMany({username:'username'})

#### update

db.collection_name.update(query, update, ...) db.user.update({username:'username'}, {$set:{password:'mongo_password'}})

#### find

db.collection_name.find(query, ...)  
db.user.find({username: {$gte: 'user'}}) $gt $gte $lt $lte > >= < <=  
db.user.find({username: 'username', password: 'password'}) and   
db.user.find({$or: [{username: 'username'}, {password: 'password'}]}) or  
db.user.find({username: {$type: 'string'}}) type  
db.user.find().limit(1).skip(0) limit skip  
db.user.find().sort({username: 1, password: -1}) sort username升序password降序

#### index

db.collection_name.createIndex(keys, options)  
db.user.createIndex({username: 1}) 创建username的升序索引

#### aggregate

db.collection_name.aggregate()  
db.user.aggregate({$group: {_id: '$username', avg: {$avg: '$age'}}})
