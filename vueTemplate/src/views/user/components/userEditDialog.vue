<!--
 * @Author: 杨旭晨
 * @Date: 2020-07-28 09:54:47
 * @Descripttion: 用户编辑弹窗
 * @LastEditors: 杨旭晨
 * @LastEditTime: 2020-07-28 11:22:43
-->
<template>
  <div class="user-edit-dialog">
    <el-dialog
      title="编辑用户"
      :visible.sync="isShow"
      width="40%"
      :before-close="handleClose"
      :close-on-click-modal="false"
      destroy-on-close
    >
      <UserForm :form="editUser" operation="edit" @onSubmit="onSubmit" @handleClose="handleClose" />
    </el-dialog>
  </div>
</template>
<script>
import UserForm from './userForm'
export default {
  name: 'UserEditDialog',
  components: {
    UserForm
  },
  props: {
    isShow: { // 是否显示弹窗
      type: Boolean,
      default: false
    },
    editUser: {
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
     * @Date: 2020-07-28 09:56:11
     * @LastEditors: 杨旭晨
     * @Descripttion: 点击关闭按钮
     */
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          this.$emit('handleClose')
          done()
        })
        .catch(_ => {})
    },
    /**
     * @Author: 杨旭晨
     * @Date: 2020-07-28 10:14:11
     * @LastEditors: 杨旭晨
     * @Descripttion: 表单当中，点击提交按钮
     * @param data 表单数据
     */
    onSubmit(data) {
      this.$emit('onSubmit', data)
    }
  }
}
</script>
<style lang="scss" scoped>
</style>
