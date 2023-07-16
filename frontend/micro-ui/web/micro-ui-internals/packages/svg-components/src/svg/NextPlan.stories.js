import React from "react";
import { NextPlan } from "./NextPlan";

export default {
  tags: ['autodocs'],
  argTypes: {
    className: {
        options: ['custom-class'],
        control: { type: 'check' },
    }
  },
  title: "NextPlan",
  component: NextPlan,
};

export const Default = () => <NextPlan />;
export const Fill = () => <NextPlan fill="blue" />;
export const Size = () => <NextPlan height="50" width="50" />;
export const CustomStyle = () => <NextPlan style={{ border: "1px solid red" }} />;
export const CustomClassName = () => <NextPlan className="custom-class" />;
