// pages/register/register.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  formSubmit: function (e) {
    let password = e.detail.value.password
    let check = e.detail.value.check
    if (password !== check) {
      return wx.showToast({
        title: '两次密码不相同'
      })
    }
    wx.request({
      url: 'http://localhost:8080/fan-api/user/register',
      data: {
        username: e.detail.value.username,
        password: e.detail.value.password,
        phone: e.detail.value.phone
      },
      success(res) {
        if (res.data.code !== 1000) {
          return wx.showToast({
            title: '注册失败'
          })
        }
        wx.showToast({
          title: '注册成功',
          success() {
            wx.navigateTo({
              url: '../login/login'
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