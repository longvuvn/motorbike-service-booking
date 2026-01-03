import { useFormik } from "formik";
import React, { useState } from "react";
import * as Yup from "yup";
import { api } from "../../config/apiConfig";
import { useNavigate } from "react-router-dom";
import { jwtDecode } from "jwt-decode";
import Cookies from 'js-cookie';

const FormikYupForm = () => {
    const navigate = useNavigate();
    const [serverError, setServerError] = useState("");

    const formik = useFormik({
      initialValues: {
        username: "",
        password: "",
      },
      validationSchema: Yup.object({
        username: Yup.string()
          .max(255, "Must be 255 characters or less")
          .required("Nhập tên đăng nhập"),
        password: Yup.string()
          .min(6, "Must be at least 6 characters")
          .required("Nhập mật khẩu"),
      }),
      onSubmit: async (values, { setSubmitting }) => {
        setServerError("");
        try {
          const response = await api.post("/auth/login", values);
          const { accessToken, refreshToken } = response.data;
          localStorage.setItem("accessToken", accessToken);
          Cookies.set('refreshToken', refreshToken, { expires: 7, secure: true, sameSite: 'strict' });
          const decodedToken = jwtDecode(accessToken);
          localStorage.setItem("user", JSON.stringify(decodedToken));
          alert("Đăng nhập thành công!");

          if (decodedToken?.role === 'ADMIN') {
            navigate("/admin");
          } else {
            navigate("/");
          }
        } catch (error) {
          const errorMessage = error.response?.data?.message || "Tên đăng nhập hoặc mật khẩu không đúng.";
          setServerError(errorMessage);
        } finally {
          setSubmitting(false);
        }
      },
    });
    return (
      <div className="min-h-screen bg-gradient-to-br flex items-center justify-center p-4">
        <div className="bg-white rounded-lg shadow-2xl p-8 w-full max-w-md">
          <h2 className="text-3xl font-bold text-center text-gray-800 mb-6">
            Đăng Nhập
          </h2>
          
          <form onSubmit={formik.handleSubmit} className="space-y-6">
            {serverError && (
              <div className="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative" role="alert">
                <span className="block sm:inline">{serverError}</span>
              </div>
            )}
            <div>
              <label htmlFor="username" className="block text-sm font-medium text-gray-700 mb-2">
                Tên đăng nhập
              </label>
              <input
                id="username"
                name="username"
                type="text"
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                value={formik.values.username}
                className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent outline-none transition"
                placeholder="Nhập tên đăng nhập"
              />
              {formik.touched.username && formik.errors.username && (
                <div className="text-red-500 text-sm mt-1">{formik.errors.username}</div>
              )}
            </div>
            <div>
              <label htmlFor="password" className="block text-sm font-medium text-gray-700 mb-2">
                Mật khẩu
              </label>
              <input
                id="password"
                name="password"
                type="password"
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                value={formik.values.password}
                className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent outline-none transition"
                placeholder="Nhập mật khẩu"
              />
              {formik.touched.password && formik.errors.password && (
                <div className="text-red-500 text-sm mt-1">{formik.errors.password}</div>
              )}
            </div>
            <button
              type="submit"
              disabled={formik.isSubmitting}
              className="w-full bg-blue-600 hover:bg-blue-700 text-white font-semibold py-3 rounded-lg transition duration-200 transform hover:scale-105 disabled:opacity-50"
            >
              {formik.isSubmitting ? 'Đang xử lý...' : 'Đăng Nhập'}
            </button>
          </form>
          <p className="text-center text-gray-600 text-sm mt-6">
            Chưa có tài khoản?{" "}
            <a href="/register" className="text-blue-600 hover:underline font-medium">
              Đăng ký ngay
            </a>
          </p>
        </div>
      </div>
    );
  };

export default function Login() {
  return <FormikYupForm />;
}