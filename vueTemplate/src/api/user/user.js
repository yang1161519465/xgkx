/*
 * @Author: 杨旭晨
 * @Date: 2020-07-24 10:40:26
 * @Descripttion: 用户api
 * @LastEditors: 杨旭晨
 * @LastEditTime: 2020-07-28 14:58:14
 */
import request from '@/utils/request'

export default {
  /**
   * @Author: 杨旭晨
   * @Date: 2020-07-28 10:16:35
   * @LastEditors: 杨旭晨
   * @Descripttion: 按条件分页查询用户
   * @param queryUser Object(User) 查询条件
   * @param pageNum int 查询第多少页
   * @param pageSize int 每页多少条
   */
  listAll(queryUser, pageNum, pageSize) {
    const params = new URLSearchParams()
    params.append('pageNum', pageNum)
    params.append('pageSize', pageSize)
    return request({
      url: 'user/list',
      method: 'post',
      params,
      data: queryUser
    })
  },
  /**
   * @Author: 杨旭晨
   * @Date: 2020-07-28 10:19:09
   * @LastEditors: 杨旭晨
   * @Descripttion: 更新用户
   * @param updateUser Object(User) 要更新的用户对象
   */
  update(updateUser) {
    return request({
      url: 'user/update',
      method: 'post',
      data: updateUser
    })
  },
  /**
   * @Author: 杨旭晨
   * @Date: 2020-07-28 11:28:31
   * @LastEditors: 杨旭晨
   * @Descripttion: 新增用户
   * @param newUser Object 新增的用户信息
   */
  add(newUser) {
    return request({
      url: 'user/add',
      method: 'post',
      data: newUser
    })
  },
  /**
   * @Author: 杨旭晨
   * @Date: 2020-07-28 11:36:22
   * @LastEditors: 杨旭晨
   * @Descripttion: 根据id删除用户
   * @param id int 要删除用户的id
   */
  delete(id) {
    return request({
      url: 'user/delete/' + id,
      method: 'post'
    })
  },
  /**
   * @Author: 杨旭晨
   * @Date: 2020-07-28 14:53:14
   * @LastEditors: 杨旭晨
   * @Descripttion: 验证用户名是否可用
   * @param username String 要验证的用户名
   */
  checkUsername(username) {
    return request({
      url: 'user/checkUsername/' + username,
      method: 'post'
    })
  },
  /**
   * @Author: 杨旭晨
   * @Date: 2020-07-28 14:53:43
   * @LastEditors: 杨旭晨
   * @Descripttion: 验证学号是否可用
   * @param stuNum String 要验证的学号
   */
  checkStuNum(stuNum) {
    return request({
      url: 'user/checkStuNum/' + stuNum,
      method: 'post'
    })
  }
}
