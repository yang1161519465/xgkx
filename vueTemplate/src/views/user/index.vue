<!--
 * @Author: 杨旭晨
 * @Date: 2020-07-24 10:40:27
 * @Descripttion: 用户组件
 * @LastEditors: 杨旭晨
 * @LastEditTime: 2020-07-28 12:06:21
-->
<template>
  <div class="app-container">
    <HeadSerch v-model="headSerchData" @onSerch="onSerch" @handleReset="handleReset" @handleNew="handleNew" />
    <UserTable
      :user-list="userList"
      :list-loading="listLoading"
      @handleEdit="handleEdit"
      @handleDelete="handleDelete"
    />
    <UserEditDialog :edit-user="editUserData" :is-show="isShowEditDialog" @handleClose="handleClose" @onSubmit="update" />
    <UserNewDialog :is-show="isShowNewDialog" @handleClose="handleClose" @onSubmit="insert" />
  </div>
</template>

<script>
import UserApi from '@/api/user/user.js'
import UserTable from './components/userTable'
import UserEditDialog from './components/userEditDialog'
import UserNewDialog from './components/userNewDialog'
import HeadSerch from './components/headSerch'
export default {
  name: 'User',
  components: {
    UserTable,
    UserEditDialog,
    HeadSerch,
    UserNewDialog
  },
  data() {
    return {
      userList: [], // 用户数据
      listLoading: true, // 表单是否处于加载状态
      queryUser: {}, // 查询的user对象
      isShowEditDialog: false, // 是否显示编辑弹窗
      editUserData: {}, // 编辑用户的信息
      isShowNewDialog: false, // 是否显示新增弹窗
      headSerchData: { // 头部搜索的数据
        id: '',
        username: '',
        name: '',
        college: '',
        className: '',
        studentNum: '',
        email: '',
        location: ''
      }
    }
  },
  mounted() {
    this.getUserList()
  },
  methods: {
    /**
     * @Author: 杨旭晨
     * @Date: 2020-07-27 21:19:17
     * @LastEditors: 杨旭晨
     * @Descripttion: 获取用户数据
     */
    getUserList() {
      UserApi.listAll(this.queryUser, 1, 5).then(res => {
        console.log('res: ', res)
        this.userList = res.data.list
        this.listLoading = false
      })
    },
    /**
     * @Author: 杨旭晨
     * @Date: 2020-07-28 10:00:46
     * @LastEditors: 杨旭晨
     * @Descripttion: 用户表格中，点击编辑按钮
     */
    handleEdit(index, row) {
      console.log('row: ', row)
      this.isShowEditDialog = true
      this.editUserData = row
    },
    /**
     * @Author: 杨旭晨
     * @Date: 2020-07-28 10:07:45
     * @LastEditors: 杨旭晨
     * @Descripttion: 点击关闭弹窗
     */
    handleClose() {
      this.isShowEditDialog = false
      this.isShowNewDialog = false
    },
    /**
     * @Author: 杨旭晨
     * @Date: 2020-07-28 10:15:21
     * @LastEditors: 杨旭晨
     * @Descripttion: 表单中点击提交按钮
     * @param updateUser Object 表单信息
     * @return:
     */
    update(updateUser) {
      this.listLoading = true // 启动表格加载状态
      UserApi.update(updateUser).then(res => {
        if (res.msg === 'success') { // 更新成功
          this.$message({
            message: '修改成功',
            type: 'success'
          })
          this.isShowEditDialog = false // 关闭弹窗
          this.getUserList() // 更新成功，重新获取数据
        } else { // 更新失败
          this.$message({
            message: res.msg,
            type: 'error'
          })
        }
      })
    },
    /**
     * @Author: 杨旭晨
     * @Date: 2020-07-28 10:47:35
     * @LastEditors: 杨旭晨
     * @Descripttion: 点击头部搜索按钮
     */
    onSerch() {
      this.listLoading = true // 启动表格加载状态
      this.queryUser = this.headSerchData
      this.getUserList()
    },
    handleReset() {
      console.log('重置')
      this.headSerchData = { // 头部搜索的数据
        id: '',
        username: '',
        name: '',
        college: '',
        className: '',
        studentNum: '',
        email: '',
        location: ''
      }
    },
    /**
     * @Author: 杨旭晨
     * @Date: 2020-07-28 11:15:32
     * @LastEditors: 杨旭晨
     * @Descripttion: 点击头部搜索中的新增按钮
     */
    handleNew() {
      this.isShowNewDialog = true
    },
    /**
     * @Author: 杨旭晨
     * @Date: 2020-07-28 11:24:14
     * @LastEditors: 杨旭晨
     * @Descripttion: 新增用户
     * @param newUser Object 新增的用户信息
     */
    insert(newUser) {
      console.log('newUser: ', newUser)
      UserApi.add(newUser).then(res => {
        if (res.msg === 'success') { // 添加成功
          this.$message({
            message: '添加成功',
            type: 'success'
          })
          this.isShowNewDialog = false // 关闭弹窗
          this.getUserList() // 更新成功，重新获取数据
        } else { // 更新失败
          this.$message({
            message: res.msg,
            type: 'error'
          })
        }
      })
    },
    /**
     * @Author: 杨旭晨
     * @Date: 2020-07-28 11:34:23
     * @LastEditors: 杨旭晨
     * @Descripttion: 点击删除按钮
     * @param index  Number  当前行下标
     * @param row  Object  当前行数据
     */
    handleDelete(index, row) {
      UserApi.delete(row.id).then(res => {
        if (res.msg === 'success') { // 更新成功
          this.$message({
            message: '删除成功',
            type: 'success'
          })
          this.getUserList() // 更新成功，重新获取数据
        } else { // 更新失败
          this.$message({
            message: res.msg,
            type: 'error'
          })
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped></style>
