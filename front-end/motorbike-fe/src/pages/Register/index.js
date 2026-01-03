import React, { useState } from "react";
import { useFormik } from "formik";
import * as Yup from "yup";
import { api } from "../../config/apiConfig";
import { useNavigate } from "react-router-dom";

const FormikYupForm = () => {
  const navigate = useNavigate();
  const [serverError, setServerError] = useState("");
  const formik = useFormik({
    initialValues: {
      fullName: "",
      userName: "",
      email: "",
      password: "",
      phoneNumber: "",
    },
    validationSchema: Yup.object({
      fullName: Yup.string()
        .max(50, "Must be 50 characters or less")
        .required("Họ và tên không được để trống"),
      userName: Yup.string()
        .max(15, "Must be 15 characters or less")
        .required("UserName không được để trống"),
      email: Yup.string()
        .email("Invalid email address")
        .required("Email không được để trống"),
      phoneNumber: Yup.string()
        .matches(/^[0-9]{10}$/, "Must be a valid 10-digit phone number")
        .required("Số điện thoại không được để trống"),
      password: Yup.string()
        .min(6, "Must be at least 6 characters")
        .required("Mật khẩu không được để trống"),
      confirmPassword: Yup.string()
        .oneOf([Yup.ref("password"), null], "Passwords must match")
        .min(6, "Must be at least 6 characters")
        .required("Xác nhận mật khẩu không được để trống"),
    }),

    onSubmit: async (values, { setSubmitting }) => {
      setServerError("");
      const response = api.post("/auth/register", values);
      response
        .then((res) => {
          if (res.status === 201) {
            navigate("/login");
          }
          alert("Đăng ký thành công!");
        })
        .catch((err) => {
          const errorMessage =
            err.response?.data?.message ||
            "Đăng ký thất bại, vui lòng thử lại.";
          alert(errorMessage);
        })
        .finally(() => {
          setSubmitting(false);
        });
    },
  });
  return (
    <div className="min-h-screen bg-gradient-to-br flex items-center justify-center p-4">
      <div className="bg-white rounded-lg shadow-2xl p-8 w-full max-w-md">
        <h2 className="text-3xl font-bold text-center text-gray-800 mb-6">
          Đăng Ký
        </h2>
        <form onSubmit={formik.handleSubmit} className="space-y-4">
          {serverError && (
            <div
              className="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative"
              role="alert"
            >
              <span className="block sm:inline">{serverError}</span>
            </div>
          )}
          <div>
            <label
              htmlFor="fullName"
              className="block text-sm font-medium text-gray-700 mb-2"
            >
              Họ và tên
            </label>
            <input
              id="fullName"
              name="fullName"
              type="text"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              value={formik.values.fullName}
              className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-purple-500 focus:border-transparent outline-none transition"
              placeholder="Nhập họ và tên"
            />
            {formik.touched.fullName && formik.errors.fullName && (
              <div className="text-red-500 text-sm mt-1">
                {formik.errors.fullName}
              </div>
            )}
          </div>
          <div>
            <label
              htmlFor="userName"
              className="block text-sm font-medium text-gray-700 mb-2"
            >
              Tên đăng nhập
            </label>
            <input
              id="userName"
              name="userName"
              type="text"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              value={formik.values.userName}
              className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-purple-500 focus:border-transparent outline-none transition"
              placeholder="Nhập tên đăng nhập"
            />
            {formik.touched.userName && formik.errors.userName && (
              <div className="text-red-500 text-sm mt-1">
                {formik.errors.userName}
              </div>
            )}
          </div>
          <div>
            <label
              htmlFor="email"
              className="block text-sm font-medium text-gray-700 mb-2"
            >
              Email
            </label>
            <input
              id="email"
              name="email"
              type="email"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              value={formik.values.email}
              className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-purple-500 focus:border-transparent outline-none transition"
              placeholder="example@email.com"
            />
            {formik.touched.email && formik.errors.email && (
              <div className="text-red-500 text-sm mt-1">
                {formik.errors.email}
              </div>
            )}
          </div>
          <div>
            <label
              htmlFor="phoneNumber"
              className="block text-sm font-medium text-gray-700 mb-2"
            >
              Số điện thoại
            </label>
            <input
              id="phoneNumber"
              name="phoneNumber"
              type="text"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              value={formik.values.phoneNumber}
              className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-purple-500 focus:border-transparent outline-none transition"
              placeholder="0123456789"
            />
            {formik.touched.phoneNumber && formik.errors.phoneNumber && (
              <div className="text-red-500 text-sm mt-1">
                {formik.errors.phoneNumber}
              </div>
            )}
          </div>

          <div>
            <label
              htmlFor="password"
              className="block text-sm font-medium text-gray-700 mb-2"
            >
              Mật khẩu
            </label>
            <input
              id="password"
              name="password"
              type="password"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              value={formik.values.password}
              className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-purple-500 focus:border-transparent outline-none transition"
              placeholder="Nhập mật khẩu"
            />
            {formik.touched.password && formik.errors.password && (
              <div className="text-red-500 text-sm mt-1">
                {formik.errors.password}
              </div>
            )}
          </div>
          <div>
            <label
              htmlFor="confirmPassword"
              className="block text-sm font-medium text-gray-700 mb-2"
            >
              Xác nhận mật khẩu
            </label>
            <input
              id="confirmPassword"
              name="confirmPassword"
              type="password"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              value={formik.values.confirmPassword}
              className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-purple-500 focus:border-transparent outline-none transition"
              placeholder="Nhập lại mật khẩu"
            />
            {formik.touched.confirmPassword &&
              formik.errors.confirmPassword && (
                <div className="text-red-500 text-sm mt-1">
                  {formik.errors.confirmPassword}
                </div>
              )}
          </div>

          <button
            type="submit"
            disabled={formik.isSubmitting}
            className="w-full bg-purple-600 hover:bg-purple-700 text-white font-semibold py-3 rounded-lg transition duration-200 transform hover:scale-105 disabled:opacity-50 disabled:cursor-not-allowed"
          >
            {formik.isSubmitting ? "Đang xử lý..." : "Đăng Ký"}
          </button>
        </form>

        <p className="text-center text-gray-600 text-sm mt-6">
          Đã có tài khoản?{" "}
          <a
            href="/login"
            className="text-purple-600 hover:underline font-medium"
          >
            Đăng nhập ngay
          </a>
        </p>
      </div>
    </div>
  );
};

export default function Register() {
  return (
    <div>
      <FormikYupForm />
    </div>
  );
}
