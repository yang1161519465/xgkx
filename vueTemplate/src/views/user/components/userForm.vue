<!--
 * @Author: 杨旭晨
 * @Date: 2020-07-28 09:32:10
 * @Descripttion: 用户信息表单
 * @LastEditors: 杨旭晨
 * @LastEditTime: 2020-07-29 08:22:28
-->
<template>
  <div class="user-form">
    <el-form
      ref="form"
      :rules="rules"
      :model="data"
      label-width="80px"
      :hide-required-asterisk="true"
      :status-icon="true"
      :validate-on-rule-change="true"
    >
      <el-form-item v-if="operation === 'edit'" label="id">
        <el-input v-model="data.id" :disabled="true" clearable />
      </el-form-item>
      <el-form-item label="用户名" prop="username">
        <el-input v-model="data.username" clearable />
      </el-form-item>
      <el-form-item label="姓名" prop="name">
        <el-input v-model="data.name" clearable />
      </el-form-item>
      <!-- <el-form-item v-if="operation === 'new'" label="密码" prop="passwordHash">
        <el-input v-model="data.passwordHash" clearable />
      </el-form-item> -->
      <el-form-item label="学院" prop="college">
        <el-input v-model="data.college" clearable />
      </el-form-item>
      <el-form-item label="班级" prop="className">
        <el-input v-model="data.className" clearable />
      </el-form-item>
      <el-form-item label="学号" prop="studentNum">
        <el-input v-model="data.studentNum" clearable />
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="data.email" clearable />
      </el-form-item>
      <el-form-item label="地理位置" prop="location">
        <el-input v-model="data.location" clearable />
      </el-form-item>
      <el-form-item label="个人介绍">
        <el-input v-model="data.aboutMe" type="textarea" autosize placeholder="请输入内容" />
      </el-form-item>
      <el-form-item>
        <el-button @click="handleClose">取消</el-button>
        <el-button type="primary" @click="onSubmit">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import UserApi from '@/api/user/user'
export default {
  name: 'UserForm',
  components: {},
  props: {
    form: {
      type: Object,
      required: true
    },
    operation: {
      type: String,
      required: true
    }
  },
  data() {
    var checkUsername = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入用户名'))
      } else {
        UserApi.checkUsername(value).then(res => {
          console.log('res: ', res)
          if (res.code === -1) {
            callback(new Error('用户名已存在'))
          } else {
            callback()
          }
        })
      }
    }
    var checkStuNum = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入学号'))
      } else {
        UserApi.checkStuNum(value).then(res => {
          console.log('res: ', res)
          if (res.code === -1) {
            callback(new Error('学号已存在'))
          } else {
            callback()
          }
        })
      }
    }
    return {
      data: {}, // 表单数据
      rules: { // 表单验证规则
        username: [
          { validator: checkUsername, trigger: 'blur' }
        ],
        name: [
          { required: true, message: '请输入真实姓名', trigger: 'blur' }
        ],
        college: [
          { required: true, message: '请选择学院', trigger: 'blur' }
        ],
        className: [
          { required: true, message: '请选择班级', trigger: 'blur' }
        ],
        studentNum: [
          { validator: checkStuNum, trigger: 'blur' }
        ],
        email: [
          { required: true, message: '请输入邮箱', trigger: 'blur' },
          { type: 'email', message: '请输入正确的邮箱地址', trigger: 'blur' }
        ],
        passwordHash: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
        ],
        location: [
          { required: true, message: '请输入地理位置', trigger: 'blur' }
        ]
      }
    }
  },
  created() {},
  mounted() {
    this.data = { ...this.form } // 将form复制给data
  },
  methods: {
    /**
     * @Author: 杨旭晨
     * @Date: 2020-07-28 10:35:32
     * @LastEditors: 杨旭晨
     * @Descripttion: 点击提交按钮
     */
    onSubmit() {
      this.$refs['form'].validate((valid) => {
        if (valid) {
          this.$emit('onSubmit', this.data)
        } else {
          return false
        }
      })
    },
    /**
     * @Author: 杨旭晨
     * @Date: 2020-07-28 10:36:02
     * @LastEditors: 杨旭晨
     * @Descripttion: 点击取消按钮
     */
    handleClose() {
      this.$emit('handleClose')
    }
  }
}
</script>
<style lang="scss" scoped></style>
