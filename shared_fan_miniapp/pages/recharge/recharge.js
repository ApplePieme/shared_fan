// pages/recharge/recharge.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  formSubmit: function (e) {
    wx.getStorage({
      key: 'userId',
      success(res) {
        wx.request({
          url: 'http://localhost:8080/fan-api/user/add-assets',
          data: {
            userId: res.data,
            value: e.detail.value.value
          },
          success(res) {
            if (res.data.code !== 1000) {
              return wx.showToast({
                title: '充值失败'
              })
            }
            wx.showToast({
              title: '充值成功',
              success() {
                wx.reLaunch({
                  url: '../info/info'
                })
              }
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