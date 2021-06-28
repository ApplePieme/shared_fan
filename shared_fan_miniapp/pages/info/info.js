// pages/info/info.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isLogin: false,
    userInfo: null
  },

  /**
   * 前往注册页面
   */
  register: function () {
    wx.navigateTo({
      url: '../register/register'
    })
  },

  /**
   * 前往登录页面
   */
  login: function () {
    wx.navigateTo({
      url: '../login/login'
    })
  },

  /**
   * 注销
   */
  logout: function () {
    let that = this
    wx.removeStorage({
      key: 'userId',
      success() {
        that.checkAccount()
      }
    })
  },

  /**
   * 前往充值
   */
  recharge: function () {
    wx.navigateTo({
      url: '../recharge/recharge'
    })
  },

  /**
   * 检查登录状态
   */
  checkAccount() {
    let that = this
    wx.getStorage({
      key: 'userId',
      success(res) {
        if (res.data !== null) {
          that.setData({
            isLogin: true
          })
        } else {
          that.setData({
            isLogin: false
          })
        }
      },
      fail() {
        that.setData({
          isLogin: false
        })
      }
    })
  },

  /**
   * 获取用户信息
   */
  getUserInfo() {
    let that = this
    wx.getStorage({
      key: 'userId',
      success(res) {
        wx.request({
          url: 'http://localhost:8080/fan-api/user/info',
          data: {
            userId: res.data
          },
          success(res) {
            that.setData({
              userInfo: res.data.data
            })
          }
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.checkAccount()
    this.getUserInfo()
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})