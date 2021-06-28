// pages/detail/detail.js
var intt;
Page({

  /**
   * 页面的初始数据
   */
  data: {
    fanInfo: null,
    beginTime: null,
    isUse: false,
    hour: 0,
    minute: 0,
    second: 0,
    millisecond: 0,
    timecount: '00:00:00'
  },

  /**
   * 开始计时
   */
  startTime() {
    var that = this;
    //时间重置
    that.setData({
      hour: 0,
      minute: 0,
      second: 0,
      millisecond: 0,
    })
    intt = setInterval(function () { that.timer() }, 50);
  },

  timer: function () {
    var that = this;
    that.setData({
      millisecond: that.data.millisecond + 5
    })
    if (that.data.millisecond >= 100) {
      that.setData({
        millisecond: 0,
        second: that.data.second + 1
      })
    }
    if (that.data.second >= 60) {
      that.setData({
        second: 0,
        minute: that.data.minute + 1
      })
    }

    if (that.data.minute >= 60) {
      that.setData({
        minute: 0,
        hour: that.data.hour + 1
      })
    }
    that.setData({
      timecount: (that.data.hour >= 10 ? that.data.hour : "0" + that.data.hour) + ":" + (that.data.minute >= 10 ? that.data.minute : "0" + that.data.minute) + ":" + (that.data.second >= 10 ? that.data.second : "0" + that.data.second)
    })
  },

  /**
   * 开始使用小风扇
   */
  beginOrder: function () {
    let that = this
    wx.getStorage({
      key: 'userId',
      success(res) {
        if (res.data !== null) {
          that.setData({
            beginTime: new Date().getTime() + (8 * 60 * 60 * 1000),
            isUse: true
          })
          that.startTime()
        } else {
          wx.showToast({
            title: '请先登录',
            success() {
              wx.navigateTo('../login/login')
            }
          })
        }
      },
      fail() {
        wx.showToast({
          title: '请先登录',
          success() {
            wx.navigateTo('../login/login')
          }
        })
      }
    })
  },

  /**
   * 结束使用小风扇
   */
  endOrder: function () {
    let endTime = new Date().getTime() + (8 * 60 * 60 * 1000)
    let that = this
    let sum = ((endTime - that.data.beginTime) / 1000 / 60 / 60) * that.data.fanInfo.price
    wx.getStorage({
      key: 'userId',
      success(res) {
        wx.request({
          url: 'http://localhost:8080/fan-api/order/add',
          data: {
            fanId: that.data.fanInfo.fanId,
            userId: res.data,
            beginTime: that.data.beginTime,
            endTime: endTime,
            sum: sum
          },
          success(res) {
            if (res.data.code !== 1000) {
              return wx.showToast({
                title: '请充值'
              })
            }
            wx.reLaunch({
              url: '../index/index'
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
    let that = this
    const eventChannel = this.getOpenerEventChannel()
    // 监听acceptDataFromOpenerPage事件，获取上一页面通过eventChannel传送到当前页面的数据
    eventChannel.on('acceptDataFromOpenerPage', function (data) {
      that.setData({
        fanInfo: data.data
      })
    })
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