<!--
 * @Author: 杨旭晨
 * @Date: 2020-07-28 10:33:49
 * @Descripttion:
 * @LastEditors: 杨旭晨
 * @LastEditTime: 2020-07-28 11:15:06
-->
<template>
  <div class="hand-serch">
    <el-form ref="headForm" :model="value" label-width="80px" :inline="true">
      <el-form-item label="id" prop="id">
        <el-input v-model="value.id" clearable />
      </el-form-item>
      <el-form-item label="用户名" prop="username">
        <el-input v-model="value.username" clearable />
      </el-form-item>
      <el-form-item label="姓名" prop="name">
        <el-input v-model="value.name" clearable />
      </el-form-item>
      <el-form-item label="学院" prop="college">
        <el-input v-model="value.college" clearable />
      </el-form-item>
      <el-form-item label="班级" prop="className">
        <el-input v-model="value.className" clearable />
      </el-form-item>
      <el-form-item label="学号" prop="studentNum">
        <el-input v-model="value.studentNum" clearable />
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="value.email" clearable />
      </el-form-item>
      <el-form-item label="地理位置" prop="location">
        <el-input v-model="value.location" clearable />
      </el-form-item>
      <el-form-item>
        <el-button @click="handleReset">重置</el-button>
        <el-button type="primary" @click="onSerch">搜索</el-button>
        <el-button type="info" @click="handleNew">新增</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  name: 'HandSerch',
  components: {},
  props: {
    value: {
      type: Object,
      default: () => {}
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
     * @Date: 2020-07-28 10:46:48
     * @LastEditors: 杨旭晨
     * @Descripttion: 点击搜索按钮
     */
    onSerch() {
      this.$emit('onSerch')
    },
    /**
     * @Author: 杨旭晨
     * @Date: 2020-07-28 10:53:47
     * @LastEditors: 杨旭晨
     * @Descripttion: 点击重置按钮
     */
    handleReset() {
      this.$refs['headForm'].resetFields()
      // this.$emit('handleReset')
    },
    /**
     * @Author: 杨旭晨
     * @Date: 2020-07-28 11:14:47
     * @LastEditors: 杨旭晨
     * @Descripttion: 点击新增按钮
     */
    handleNew() {
      this.$emit('handleNew')
    }
  }
}
</script>
<style lang="scss" scoped>
</style>
