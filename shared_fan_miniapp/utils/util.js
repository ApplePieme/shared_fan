const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return `${[year, month, day].map(formatNumber).join('/')} ${[hour, minute, second].map(formatNumber).join(':')}`
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : `0${n}`
}

const baseURL = 'http://localhost:8080/fan-api/'

const wxRequest = (url, data, callback) => {
  wx.getStorage({
    key: 'token',
    complete(res) {
      let token = res.data
      wx.getStorage({
        key: 'sessionId',
        complete(res) {
          wx.request({
            url: baseURL + url,
            data: data,
            header: {
              token: token,
              cookie: 'JSESSIONID = ' + res.data
            },
            success(res) {
              callback(res)
            }
          })
        }
      })
    }
  })
}

module.exports = {
  formatTime,
  wxRequest
}
