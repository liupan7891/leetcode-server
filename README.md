# leetcode-server

Dependencies:

    Java 1.8 <br/>
    Gradle 2.9 <br/>

Supported protocol:
	
	Rest

Import:

    gradle idea
    gradle eclipse
    
Run:

    ./gradlew bootRun


---------

## Changelog 须知

#### Git commit 原则

* 避免重复的commit 提交
* 避免无意义的commmit 提交 如： 11  2 2 3 3
* -m 内容 避免使用英文
* 上线之前的commit 一定要包含TB做过所有的job内容，并且要与代码一致，如不一致清使用`git rebase `合并多条



#### Git commit 基本规范


* **type:** 代表某次提交的类型，比如是修复一个bug还是增加一个新的feature。所有的type类型如下：
* **feat:** 新增feature，新功能
* **fix:** 修复bug
* **docs:** 仅仅修改了文档，比如README, CHANGELOG, CONTRIBUTE等等
* **style:** 仅仅修改了空格、格式缩进、都好等等，不改变代码逻辑
* **refactor:** 代码重构，没有加新功能或者修复bug
* **perf:** 优化相关，比如提升性能、体验
* **test:** 测试用例，包括单元测试、集成测试等
* **chore:** 改变构建流程、或者增加依赖库、工具等
* **revert:** 回滚到上一个版本



#### 示例:

##### 注意： commit 的内容一定要包含TB中自己工作所有的job，并且内容要一致!!!


    git commit -m 'perf: 客户动态→已绑定的设备加icon和收起按钮，见关联文件'
    git commit -m 'feat: 销售易未注册过KD账号的，需要弹出绑定二维码'
    git commit -m 'fix: 通话历史中通话时长与客户动态中通话时长不一致'



#### git rebase 压缩

    git rebase -i HEAD~4

修改第一个是pick 剩下都是squash


    pick 5e187c7dbe8    add center style indent
    squash 6d577eb3440  add center style
    squash f9b9508a3ab  add center style
    squash 111ab9cc261  update templates

