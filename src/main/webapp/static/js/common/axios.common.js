var pendingAjax = [];
const fastClickMsg = '数据请求中，请稍后';
const CancelToken = axios.CancelToken;
const removePendingAjax = (config, c) => {
    const url = config.url;
    const index = pendingAjax.findIndex(i => i === url)
    if (index > -1) {
        c ? c(fastClickMsg) : pendingAjax.splice(index, 1)
    } else {
        c && pendingAjax.push(url)
    }
};

// Add a request interceptor
axios.interceptors.request.use(
    function (config) {
        // Do something before request is sent
        config.cancelToken = new CancelToken(c => {
            removePendingAjax(config, c)
        });
        return config
    },
    function (error) {
        // Do something with request error
        return Promise.reject(error)
    }
);

// Add a response interceptor
axios.interceptors.response.use(
    function (response) {
        // Any status code that lie within the range of 2xx cause this function to trigger
        // Do something with response data
        removePendingAjax(response.config);
        return new Promise((resolve, reject) => {
            if (response.data.status !== 1) {
                resolve(response);
            } else {
                resolve(response);
            }
        })
    },
    function (error) {
        // Any status codes that falls outside the range of 2xx cause this function to trigger
        // Do something with response error
        Message.error(error);
        return Promise.resolve(error)
    }
);