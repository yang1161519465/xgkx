<!--
 * @Author: 杨旭晨
 * @Date: 2020-07-24 12:05:51
 * @Descripttion: 用户表格
 * @LastEditors: 杨旭晨
 * @LastEditTime: 2020-07-28 12:00:47
-->
<template>
  <div class="user-table">
    <el-table v-loading="listLoading" :data="userList" style="width: 100%" border stripe>
      <el-table-column prop="id" label="id" align="center" />
      <el-table-column prop="username" label="用户名" align="center" />
      <el-table-column prop="name" label="姓名" align="center" />
      <el-table-column prop="college" label="学院" align="center" />
      <el-table-column prop="className" label="班级" align="center" />
      <el-table-column prop="studentNum" label="学号" align="center" />
      <el-table-column prop="email" label="电子邮件" align="center" />
      <el-table-column prop="location" label="地理位置" align="center" />
      <el-table-column prop="aboutMe" label="个人介绍" align="center" />
      <el-table-column prop="confirmed" label="邮箱验证" align="center" :formatter="formatConfirmed" />
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
import USER_CONST from '@/constant/user-const'
export default {
  name: 'UserTable',
  components: {},
  props: {
    userList: {
      type: Array,
      required: true,
      default: () => []
    },
    listLoading: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {

    }
  },
  created() {},
  mounted() {},
  methods: {
    /**
     * @Author: 杨旭晨
     * @Date: 2020-07-28 09:59:17
     * @LastEditors: 杨旭晨
     * @Descripttion: 格式化邮箱验证字段
     * @param row  Object  当前行数据
     */
    formatConfirmed(row) {
      if (row.confirmed === USER_CONST.TRUE) {
        return '已验证'
      } else if (row.confirmed === USER_CONST.FALSE) {
        return '未验证'
      } else {
        return '数据错误'
      }
    },
    /**
     * @Author: 杨旭晨
     * @Date: 2020-07-24 16:07:23
     * @LastEditors: 杨旭晨
     * @Descripttion: 点击编辑按钮
     * @param index  Number  当前行下标
     * @param row  Object  当前行数据
     */
    handleEdit(index, row) {
      this.$emit('handleEdit', index, row) // 执行绑定的方法
    },
    /**
     * @Author: 杨旭晨
     * @Date: 2020-07-28 11:33:38
     * @LastEditors: 杨旭晨
     * @Descripttion: 点击删除按钮
     * @param index  Number  当前行下标
     * @param row  Object  当前行数据
     */
    handleDelete(index, row) {
      this.$emit('handleDelete', index, row)
    }
  }
}
</script>
<style lang="scss" scoped>
</style>
